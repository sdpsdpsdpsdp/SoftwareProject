package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDataLog;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDataLogService 
 * @Description: 实现类 SysDataLogServiceImpl
 * @author lihua
 * @date  2023-03-29 14:09:20
 */
public interface SysDataLogService extends BaseService<SysDataLog,String>{
	
    /**
	 *  CACHE_NAME     SysDataLog
	 */
	public final static String CACHE_NAME = "SysDataLog";
	
	/**
	 * 查询符合条件的 SysDataLog的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDataLog
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDataLog
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDataLog
	 * @param SysDataLog record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDataLog record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDataLog
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDataLog>
	 * @throws Exception
	 */
	List<SysDataLog> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDataLog
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDataLog>
	 * @throws Exception
	 */
	PageInfo<SysDataLog> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDataLog
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDataLog  record
	 * @throws Exception
	 */
	SysDataLog selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDataLog
	 * @param String id
	 * @return  SysDataLog  record
	 * @throws Exception
	 */
	SysDataLog selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDataLog 更新为SysDataLog  record
	 * @param String id
	 * @return  SysDataLog  record
	 * @throws Exception
	 */
	int updateByCondition(SysDataLog record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDataLog
	 * @param SysDataLog record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDataLog record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
