package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDataSource;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDataSourceService 
 * @Description: 实现类 SysDataSourceServiceImpl
 * @author lihua
 * @date  2023-03-29 14:09:40
 */
public interface SysDataSourceService extends BaseService<SysDataSource,String>{
	
    /**
	 *  CACHE_NAME     SysDataSource
	 */
	public final static String CACHE_NAME = "SysDataSource";
	
	/**
	 * 查询符合条件的 SysDataSource的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDataSource
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDataSource
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDataSource
	 * @param SysDataSource record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDataSource record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDataSource
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDataSource>
	 * @throws Exception
	 */
	List<SysDataSource> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDataSource
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDataSource>
	 * @throws Exception
	 */
	PageInfo<SysDataSource> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDataSource
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDataSource  record
	 * @throws Exception
	 */
	SysDataSource selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDataSource
	 * @param String id
	 * @return  SysDataSource  record
	 * @throws Exception
	 */
	SysDataSource selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDataSource 更新为SysDataSource  record
	 * @param String id
	 * @return  SysDataSource  record
	 * @throws Exception
	 */
	int updateByCondition(SysDataSource record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDataSource
	 * @param SysDataSource record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDataSource record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
