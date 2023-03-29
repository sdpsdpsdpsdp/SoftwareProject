package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDepartRolePermission;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDepartRolePermissionService 
 * @Description: 实现类 SysDepartRolePermissionServiceImpl
 * @author lihua
 * @date  2023-03-27 16:39:18
 */
public interface SysDepartRolePermissionService extends BaseService<SysDepartRolePermission,String>{
	
    /**
	 *  CACHE_NAME     SysDepartRolePermission
	 */
	public final static String CACHE_NAME = "SysDepartRolePermission";
	
	/**
	 * 查询符合条件的 SysDepartRolePermission的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDepartRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDepartRolePermission
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDepartRolePermission
	 * @param SysDepartRolePermission record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDepartRolePermission record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDepartRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDepartRolePermission>
	 * @throws Exception
	 */
	List<SysDepartRolePermission> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDepartRolePermission
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDepartRolePermission>
	 * @throws Exception
	 */
	PageInfo<SysDepartRolePermission> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDepartRolePermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDepartRolePermission  record
	 * @throws Exception
	 */
	SysDepartRolePermission selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDepartRolePermission
	 * @param String id
	 * @return  SysDepartRolePermission  record
	 * @throws Exception
	 */
	SysDepartRolePermission selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDepartRolePermission 更新为SysDepartRolePermission  record
	 * @param String id
	 * @return  SysDepartRolePermission  record
	 * @throws Exception
	 */
	int updateByCondition(SysDepartRolePermission record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDepartRolePermission
	 * @param SysDepartRolePermission record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDepartRolePermission record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
