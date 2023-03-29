package com.laison.softwareproject.service;

import com.laison.softwareproject.common.api.dto.LogDTO;
import com.laison.softwareproject.common.utils.IpUtils;
import com.laison.softwareproject.common.utils.MyIDGenId;
import com.laison.softwareproject.common.utils.SpringContextUtils;
import com.laison.softwareproject.common.utils.oConvertUtils;
import com.laison.softwareproject.model.sys.SysUser;
import com.laison.softwareproject.service.sys.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Description: common实现类
 * @author: jeecg-boot
 */
@Service
@Slf4j
public class BaseCommonServiceImpl implements BaseCommonService {

    @Resource
    private SysLogService baseCommonMapper;

    @Override
    public void addLog(LogDTO logDTO) {
        if (oConvertUtils.isEmpty(logDTO.getId())) {
            logDTO.setId(MyIDGenId.genID());
        }
        //保存日志（异常捕获处理，防止数据太大存储失败，导致业务失败）JT-238
        try {
            logDTO.setCreateTime(new Date());
            baseCommonMapper.save(logDTO);
        } catch (Exception e) {
            log.warn(" LogContent length : " + logDTO.getLogContent().length());
            log.warn(e.getMessage());
        }
    }

    @Override
    public void addLog(String logContent, Integer logType, Integer operatetype, SysUser user) {
        LogDTO sysLog = new LogDTO();
        sysLog.setId(String.valueOf(MyIDGenId.genID()));
        //注解上的描述,操作日志内容
        sysLog.setLogContent(logContent);
        sysLog.setLogType(logType);
        sysLog.setOperateType(operatetype);
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
                user = (SysUser) SecurityUtils.getSubject().getPrincipal();
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
            baseCommonMapper.save(sysLog);
        } catch (Exception e) {
            log.warn(" LogContent length : " + sysLog.getLogContent().length());
            log.warn(e.getMessage());
        }
    }

    @Override
    public void addLog(String logContent, Integer logType, Integer operateType) {
        addLog(logContent, logType, operateType, null);
    }


}
