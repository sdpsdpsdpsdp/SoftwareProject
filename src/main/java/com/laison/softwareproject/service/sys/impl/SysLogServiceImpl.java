package com.laison.softwareproject.service.sys.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.laison.softwareproject.common.api.dto.LogDTO;
import com.laison.softwareproject.common.utils.*;
import com.laison.softwareproject.model.sys.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.laison.softwareproject.common.constants.ConfigConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import com.laison.softwareproject.model.sys.SysLog;
import com.laison.softwareproject.dao.sys.SysLogDao;
import com.laison.softwareproject.service.sys.SysLogService;

import javax.servlet.http.HttpServletRequest;


/**
 * @author lihua 496583747@qq.com
 * @date 2023-03-27 16:40:39
 */
@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService {


    @Autowired
    private SysLogDao sysLogDao;


    @Override
    public int countByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysLogDao.selectCountByExample(example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)// 清空  缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysLogDao.deleteByExample(example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#id") // 清空 缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(String id) throws Exception {

        return sysLogDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int save(SysLog record) throws Exception {
        return sysLogDao.insertSelective(record);
    }

    @Override
    public int save(LogDTO record) throws Exception {
        SysLog sysLog = new SysLog();
        BeanUtils.copyProperties(record, sysLog);
        return save(sysLog);
    }

    @Override
    public List<SysLog> selectAllByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        if (ConfigConstant.ISOLATE_ENABLE) {
            LoginUserUtil.addIsolate(example);
        }
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        return sysLogDao.selectByExample(example);
    }

    @Override
    public PageInfo<SysLog> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
            throws Exception {
        Example example = createExample(condition);
        if (ConfigConstant.ISOLATE_ENABLE) {
            LoginUserUtil.addIsolate(example);
        }
        PageHelper.startPage(pageNum, pageSize, true);
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        List<SysLog> list = sysLogDao.selectByExample(example);
        PageInfo<SysLog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysLog selectFirstByCondition(HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        String orderByClause = (String) condition.get("orderByClause");
        if (orderByClause != null) {
            example.setOrderByClause(orderByClause);
        }
        PageHelper.startPage(1, 1, true);
        List<SysLog> list = sysLogDao.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }

    }

    @Override
    @Cacheable(value = CACHE_NAME, key = "#id", sync = true)
    public SysLog selectByPrimaryKey(String id) throws Exception {
        return sysLogDao.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, allEntries = true)// 清空  缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByCondition(SysLog record, HashMap<String, Object> condition) throws Exception {
        Example example = createExample(condition);
        return sysLogDao.updateByExample(record, example);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#record.id") // 清除 缓存
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(SysLog record) throws Exception {
        return sysLogDao.updateByPrimaryKeySelective(record);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKeys(List<String> ids) throws Exception {
        Example example = new Example(SysLog.class);
        Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        Cache cache = SpringContextUtils.getCache(CACHE_NAME);
        ((List<String>) ids).forEach((id) -> cache.evict(id));
        return sysLogDao.deleteByExample(example);
    }

    @Override
    public void addLog(SysLog logDTO) {
        if (oConvertUtils.isEmpty(logDTO.getId())) {
            logDTO.setId(MyIDGenId.genID());
        }
        //保存日志（异常捕获处理，防止数据太大存储失败，导致业务失败）JT-238
        try {
            logDTO.setCreateTime(new Date());
            save(logDTO);
        } catch (Exception e) {
            log.warn(" LogContent length : " + logDTO.getLogContent().length());
            log.warn(e.getMessage());
        }
    }

    @Override
    public void addLog(String logContent, Integer logType, Integer operateType, SysUser user) {
        SysLog sysLog = new SysLog();
        sysLog.setId(MyIDGenId.genID());
        //注解上的描述,操作日志内容
        sysLog.setLogContent(logContent);
        sysLog.setLogType(logType);
        sysLog.setOperateType(operateType);
        try {
            //获取request
            HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
            //设置IP地址
            sysLog.setIp(IpUtils.getIpAddr(request));
        } catch (Exception e) {
            sysLog.setIp("127.0.0.1");
        }
        //获取登录用户信息
        if (user == null) {
            try {
                user =LoginUserUtil.getSysUser();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        if (user != null) {
            sysLog.setUserid(user.getUsername());
            sysLog.setUsername(user.getRealname());
        }
        sysLog.setCreateTime(new Date());
        //保存日志（异常捕获处理，防止数据太大存储失败，导致业务失败）JT-238
        try {
            save(sysLog);
        } catch (Exception e) {
            log.warn(" LogContent length : " + sysLog.getLogContent().length());
            log.warn(e.getMessage());
        }
    }

    @Override
    public void addLog(String logContent, Integer logType, Integer operateType) {
        addLog(logContent, logType, operateType, null);
    }

    private Example createExample(HashMap<String, Object> condition) {
        Example example = new Example(SysLog.class);
        Example.Criteria criteria = example.createCriteria();
        if (condition != null) {
            if (condition.get("id") != null && !"".equals(condition.get("id"))) {
                criteria.andEqualTo("id", condition.get("id"));
            }
            if (condition.get("delFlag") != null && !"".equals(condition.get("delFlag"))) {
                criteria.andEqualTo("delFlag", condition.get("delFlag"));
            }
            if (condition.get("startTime") != null) {
                criteria.andGreaterThanOrEqualTo("createTime", DateUtils.parse(condition.get("startTime") + ""));

            }
            if (condition.get("endTime") != null) {
                criteria.andLessThanOrEqualTo("createTime", DateUtils.parse(condition.get("endTime") + ""));
            }
        }
        return example;
    }


}
