package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysPermissionV2;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysPermissionV2Service 
 * @Description: 实现类 SysPermissionV2ServiceImpl
 * @author lihua
 * @date  2023-03-27 16:41:05
 */
public interface SysPermissionV2Service extends BaseService<SysPermissionV2,String>{
	
    /**
	 *  CACHE_NAME     SysPermissionV2
	 */
	public final static String CACHE_NAME = "SysPermissionV2";
	
	/**
	 * 查询符合条件的 SysPermissionV2的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysPermissionV2
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysPermissionV2
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysPermissionV2
	 * @param SysPermissionV2 record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysPermissionV2 record) throws Exception;

	/**
	 * 查询所有符合条件的  SysPermissionV2
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysPermissionV2>
	 * @throws Exception
	 */
	List<SysPermissionV2> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysPermissionV2
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysPermissionV2>
	 * @throws Exception
	 */
	PageInfo<SysPermissionV2> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysPermissionV2
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysPermissionV2  record
	 * @throws Exception
	 */
	SysPermissionV2 selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysPermissionV2
	 * @param String id
	 * @return  SysPermissionV2  record
	 * @throws Exception
	 */
	SysPermissionV2 selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysPermissionV2 更新为SysPermissionV2  record
	 * @param String id
	 * @return  SysPermissionV2  record
	 * @throws Exception
	 */
	int updateByCondition(SysPermissionV2 record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysPermissionV2
	 * @param SysPermissionV2 record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysPermissionV2 record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
