package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysCheckRule;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysCheckRuleService 
 * @Description: 实现类 SysCheckRuleServiceImpl
 * @author lihua
 * @date  2023-03-29 14:08:42
 */
public interface SysCheckRuleService extends BaseService<SysCheckRule,String>{
	
    /**
	 *  CACHE_NAME     SysCheckRule
	 */
	public final static String CACHE_NAME = "SysCheckRule";
	
	/**
	 * 查询符合条件的 SysCheckRule的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysCheckRule
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysCheckRule
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysCheckRule
	 * @param SysCheckRule record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysCheckRule record) throws Exception;

	/**
	 * 查询所有符合条件的  SysCheckRule
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysCheckRule>
	 * @throws Exception
	 */
	List<SysCheckRule> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysCheckRule
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysCheckRule>
	 * @throws Exception
	 */
	PageInfo<SysCheckRule> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysCheckRule
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysCheckRule  record
	 * @throws Exception
	 */
	SysCheckRule selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysCheckRule
	 * @param String id
	 * @return  SysCheckRule  record
	 * @throws Exception
	 */
	SysCheckRule selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysCheckRule 更新为SysCheckRule  record
	 * @param String id
	 * @return  SysCheckRule  record
	 * @throws Exception
	 */
	int updateByCondition(SysCheckRule record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysCheckRule
	 * @param SysCheckRule record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysCheckRule record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
