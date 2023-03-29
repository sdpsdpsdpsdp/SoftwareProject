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
import com.laison.softwareproject.model.sys.SysTenant;
import com.laison.softwareproject.dao.sys.SysTenantDao;
import com.laison.softwareproject.service.sys.SysTenantService;





/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:42:15
*/
@Service
public class SysTenantServiceImpl implements SysTenantService{
	
	
    @Autowired
	private SysTenantDao sysTenantDao;

	
	
	@Override
	public int countByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return  sysTenantDao.selectCountByExample(example);
	}

	@Override
	@CacheEvict(value=CACHE_NAME,allEntries=true)// 清空  缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return  sysTenantDao.deleteByExample(example);
	}

	@Override
	@CacheEvict(value =CACHE_NAME, key = "#id") // 清空 缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKey(Integer id) throws Exception {
		
		return  sysTenantDao.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(SysTenant record) throws Exception {
		
		return sysTenantDao.insertSelective(record);
	}

	@Override
	public List<SysTenant> selectAllByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		if(ConfigConstant.ISOLATE_ENABLE) {
			LoginUserUtil.addIsolate(example);
		}
		String orderByClause = (String) condition.get("orderByClause");
		if(orderByClause!=null) {
			example.setOrderByClause(orderByClause);
		}
		return sysTenantDao.selectByExample(example);
	}

	@Override
	public PageInfo<SysTenant> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
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
		List<SysTenant> list = sysTenantDao.selectByExample(example);
		PageInfo<SysTenant> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public SysTenant selectFirstByCondition(HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		String orderByClause = (String) condition.get("orderByClause");
		if(orderByClause!=null) {
			example.setOrderByClause(orderByClause);
		}
		PageHelper.startPage(1, 1, true);
		List<SysTenant> list = sysTenantDao.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}else {
			return list.get(0);
		}
		
	}

	@Override
	@Cacheable(value =CACHE_NAME, key = "#id", sync=true) 
	public SysTenant selectByPrimaryKey(Integer id) throws Exception {
		return sysTenantDao.selectByPrimaryKey(id);
	}

	@Override
	@CacheEvict(value=CACHE_NAME,allEntries=true)// 清空  缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByCondition(SysTenant record, HashMap<String, Object> condition) throws Exception {
		Example example = createExample(condition);
		return sysTenantDao.updateByExample(record, example);
	}

	@Override
	@CacheEvict(value =CACHE_NAME, key = "#record.id") // 清除 缓存
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKey(SysTenant record) throws Exception {
		return sysTenantDao.updateByPrimaryKeySelective(record);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteByPrimaryKeys(List<Integer> ids) throws Exception {
		Example example =new Example(SysTenant.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("id", ids);
		Cache cache = SpringContextUtils.getCache(CACHE_NAME);
		((List<Integer>) ids).forEach((id) -> cache.evict(id));
		return sysTenantDao.deleteByExample(example);
	}

	private Example createExample(HashMap<String, Object> condition) {
		Example example = new Example(SysTenant.class);
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
