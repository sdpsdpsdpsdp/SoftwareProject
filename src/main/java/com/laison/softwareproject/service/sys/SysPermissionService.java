package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysPermission;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysPermissionService 
 * @Description: 实现类 SysPermissionServiceImpl
 * @author lihua
 * @date  2023-03-27 16:40:52
 */
public interface SysPermissionService extends BaseService<SysPermission,String>{
	
    /**
	 *  CACHE_NAME     SysPermission
	 */
	public final static String CACHE_NAME = "SysPermission";
	
	/**
	 * 查询符合条件的 SysPermission的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysPermission
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysPermission
	 * @param SysPermission record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysPermission record) throws Exception;

	/**
	 * 查询所有符合条件的  SysPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysPermission>
	 * @throws Exception
	 */
	List<SysPermission> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysPermission
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysPermission>
	 * @throws Exception
	 */
	PageInfo<SysPermission> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysPermission  record
	 * @throws Exception
	 */
	SysPermission selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysPermission
	 * @param String id
	 * @return  SysPermission  record
	 * @throws Exception
	 */
	SysPermission selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysPermission 更新为SysPermission  record
	 * @param String id
	 * @return  SysPermission  record
	 * @throws Exception
	 */
	int updateByCondition(SysPermission record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysPermission
	 * @param SysPermission record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysPermission record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
