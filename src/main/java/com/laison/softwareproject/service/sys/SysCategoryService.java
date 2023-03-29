package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysCategory;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysCategoryService 
 * @Description: 实现类 SysCategoryServiceImpl
 * @author lihua
 * @date  2023-03-27 16:23:23
 */
public interface SysCategoryService extends BaseService<SysCategory,String>{
	
    /**
	 *  CACHE_NAME     SysCategory
	 */
	public final static String CACHE_NAME = "SysCategory";
	
	/**
	 * 查询符合条件的 SysCategory的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysCategory
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysCategory
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysCategory
	 * @param SysCategory record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysCategory record) throws Exception;

	/**
	 * 查询所有符合条件的  SysCategory
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysCategory>
	 * @throws Exception
	 */
	List<SysCategory> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysCategory
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysCategory>
	 * @throws Exception
	 */
	PageInfo<SysCategory> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysCategory
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysCategory  record
	 * @throws Exception
	 */
	SysCategory selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysCategory
	 * @param String id
	 * @return  SysCategory  record
	 * @throws Exception
	 */
	SysCategory selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysCategory 更新为SysCategory  record
	 * @param String id
	 * @return  SysCategory  record
	 * @throws Exception
	 */
	int updateByCondition(SysCategory record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysCategory
	 * @param SysCategory record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysCategory record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
