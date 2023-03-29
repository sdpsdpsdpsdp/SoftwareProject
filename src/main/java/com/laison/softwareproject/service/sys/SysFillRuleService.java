package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysFillRule;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysFillRuleService 
 * @Description: 实现类 SysFillRuleServiceImpl
 * @author lihua
 * @date  2023-03-29 14:10:15
 */
public interface SysFillRuleService extends BaseService<SysFillRule,String>{
	
    /**
	 *  CACHE_NAME     SysFillRule
	 */
	public final static String CACHE_NAME = "SysFillRule";
	
	/**
	 * 查询符合条件的 SysFillRule的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysFillRule
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysFillRule
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysFillRule
	 * @param SysFillRule record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysFillRule record) throws Exception;

	/**
	 * 查询所有符合条件的  SysFillRule
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysFillRule>
	 * @throws Exception
	 */
	List<SysFillRule> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysFillRule
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysFillRule>
	 * @throws Exception
	 */
	PageInfo<SysFillRule> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysFillRule
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysFillRule  record
	 * @throws Exception
	 */
	SysFillRule selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysFillRule
	 * @param String id
	 * @return  SysFillRule  record
	 * @throws Exception
	 */
	SysFillRule selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysFillRule 更新为SysFillRule  record
	 * @param String id
	 * @return  SysFillRule  record
	 * @throws Exception
	 */
	int updateByCondition(SysFillRule record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysFillRule
	 * @param SysFillRule record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysFillRule record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
