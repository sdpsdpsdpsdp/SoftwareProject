package com.laison.softwareproject.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.laison.softwareproject.common.constants.ConfigConstant;
import com.laison.softwareproject.common.utils.LoginUserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.common.utils.SpringContextUtils;
import org.springframework.cache.Cache;
import com.laison.softwareproject.common.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
import com.laison.softwareproject.model.sys.SysDepart;
import com.laison.softwareproject.dao.sys.SysDepartDao;
import com.laison.softwareproject.service.sys.SysDepartService;





/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:38:10
*/
@Service
public class SysDepartServiceImpl implements SysDepartService{
	
	
    @Autowired
	private SysDepartDao sysDepartDao;

	
	
	@Override
	public int countByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return  sysDepartDao.selectCountByExample(example);
	}

	@Override
	@CacheEvict(value=CACHE_NAME,allEntries=true)// 清空  缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return  sysDepartDao.deleteByExample(example);
	}

	@Override
	@CacheEvict(value =CACHE_NAME, key = "#id") // 清空 缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKey(String id) throws Exception {
		
		return  sysDepartDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(SysDepart record) throws Exception {
		
		return sysDepartDao.insertSelective(record);
	}

	@Override
	public List<SysDepart> selectAllByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		if(ConfigConstant.ISOLATE_ENABLE) {
			LoginUserUtil.addIsolate(example);
		}
		String orderByClause = (String) condition.get("orderByClause");
		if(orderByClause!=null) {
			example.setOrderByClause(orderByClause);
		}
		return sysDepartDao.selectByExample(example);
	}

	@Override
	public PageInfo<SysDepart> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception {
		Example example = createExample(condition);
		if(ConfigConstant.ISOLATE_ENABLE) {
			LoginUserUtil.addIsolate(example);
		}
		PageHelper.startPage(pageNum, pageSize, true);
		String orderByClause = (String) condition.get("orderByClause");
		if(orderByClause!=null) {
			example.setOrderByClause(orderByClause);
		}
		List<SysDepart> list = sysDepartDao.selectByExample(example);
		PageInfo<SysDepart> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public SysDepart selectFirstByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		String orderByClause = (String) condition.get("orderByClause");
		if(orderByClause!=null) {
			example.setOrderByClause(orderByClause);
		}
		PageHelper.startPage(1, 1, true);
		List<SysDepart> list = sysDepartDao.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
		
	}

	@Override
	@Cacheable(value =CACHE_NAME, key = "#id", sync=true) 
	public SysDepart selectByPrimaryKey(String id) throws Exception {
		return sysDepartDao.selectByPrimaryKey(id);
	}

	@Override
	@CacheEvict(value=CACHE_NAME,allEntries=true)// 清空  缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByCondition(SysDepart record, HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return sysDepartDao.updateByExample(record, example);
	}

	@Override
	@CacheEvict(value =CACHE_NAME, key = "#record.id") // 清除 缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(SysDepart record) throws Exception {
		return sysDepartDao.updateByPrimaryKeySelective(record);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKeys(List<String> ids) throws Exception {
		Example example =new Example(SysDepart.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("id", ids);
		Cache cache = SpringContextUtils.getCache(CACHE_NAME);
		((List<String>) ids).forEach((id) -> cache.evict(id));
		return sysDepartDao.deleteByExample(example);
	}

	private Example createExample(HashMap<String, Object> condition) {
		Example example = new Example(SysDepart.class);
		Example.Criteria criteria = example.createCriteria();
		if (condition != null) {
			if (condition.get("id") != null && !"".equals(condition.get("id"))) {
				criteria.andEqualTo("id", condition.get("id"));
			}
			if (condition.get("delFlag") != null && !"".equals(condition.get("delFlag"))) {
				criteria.andEqualTo("delFlag", condition.get("delFlag"));
			}
			if (condition.get("startTime") != null ) {
				criteria.andGreaterThanOrEqualTo("createTime", DateUtils.parse(condition.get("startTime")+""));
				
			}
			if (condition.get("endTime") != null ) {
				criteria.andLessThanOrEqualTo("createTime", DateUtils.parse(condition.get("endTime")+""));
			}
		}
		return example;
	}

	
	

}
