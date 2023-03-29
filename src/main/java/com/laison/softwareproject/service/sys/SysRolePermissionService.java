package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysRolePermission;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysRolePermissionService 
 * @Description: 实现类 SysRolePermissionServiceImpl
 * @author lihua
 * @date  2023-03-27 16:42:02
 */
public interface SysRolePermissionService extends BaseService<SysRolePermission,String>{
	
    /**
	 *  CACHE_NAME     SysRolePermission
	 */
	public final static String CACHE_NAME = "SysRolePermission";
	
	/**
	 * 查询符合条件的 SysRolePermission的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysRolePermission
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysRolePermission
	 * @param SysRolePermission record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysRolePermission record) throws Exception;

	/**
	 * 查询所有符合条件的  SysRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysRolePermission>
	 * @throws Exception
	 */
	List<SysRolePermission> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysRolePermission
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysRolePermission>
	 * @throws Exception
	 */
	PageInfo<SysRolePermission> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysRolePermission  record
	 * @throws Exception
	 */
	SysRolePermission selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysRolePermission
	 * @param String id
	 * @return  SysRolePermission  record
	 * @throws Exception
	 */
	SysRolePermission selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysRolePermission 更新为SysRolePermission  record
	 * @param String id
	 * @return  SysRolePermission  record
	 * @throws Exception
	 */
	int updateByCondition(SysRolePermission record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysRolePermission
	 * @param SysRolePermission record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysRolePermission record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
