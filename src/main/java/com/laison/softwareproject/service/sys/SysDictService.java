package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDict;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDictService 
 * @Description: 实现类 SysDictServiceImpl
 * @author lihua
 * @date  2023-03-27 16:40:14
 */
public interface SysDictService extends BaseService<SysDict,String>{
	
    /**
	 *  CACHE_NAME     SysDict
	 */
	public final static String CACHE_NAME = "SysDict";
	
	/**
	 * 查询符合条件的 SysDict的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDict
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDict
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDict
	 * @param SysDict record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDict record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDict
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDict>
	 * @throws Exception
	 */
	List<SysDict> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDict
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDict>
	 * @throws Exception
	 */
	PageInfo<SysDict> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDict
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDict  record
	 * @throws Exception
	 */
	SysDict selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDict
	 * @param String id
	 * @return  SysDict  record
	 * @throws Exception
	 */
	SysDict selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDict 更新为SysDict  record
	 * @param String id
	 * @return  SysDict  record
	 * @throws Exception
	 */
	int updateByCondition(SysDict record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDict
	 * @param SysDict record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDict record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

    String queryTableDictTextByKey(String table, String text, String code, String key);

	String queryDictTextByKey(String code, String key);
}
