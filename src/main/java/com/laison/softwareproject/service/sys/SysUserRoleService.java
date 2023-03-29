package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysUserRole;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysUserRoleService 
 * @Description: 实现类 SysUserRoleServiceImpl
 * @author lihua
 * @date  2023-03-27 16:43:59
 */
public interface SysUserRoleService extends BaseService<SysUserRole,String>{
	
    /**
	 *  CACHE_NAME     SysUserRole
	 */
	public final static String CACHE_NAME = "SysUserRole";
	
	/**
	 * 查询符合条件的 SysUserRole的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysUserRole
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysUserRole
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysUserRole
	 * @param SysUserRole record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysUserRole record) throws Exception;

	/**
	 * 查询所有符合条件的  SysUserRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysUserRole>
	 * @throws Exception
	 */
	List<SysUserRole> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysUserRole
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysUserRole>
	 * @throws Exception
	 */
	PageInfo<SysUserRole> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysUserRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysUserRole  record
	 * @throws Exception
	 */
	SysUserRole selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysUserRole
	 * @param String id
	 * @return  SysUserRole  record
	 * @throws Exception
	 */
	SysUserRole selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysUserRole 更新为SysUserRole  record
	 * @param String id
	 * @return  SysUserRole  record
	 * @throws Exception
	 */
	int updateByCondition(SysUserRole record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysUserRole
	 * @param SysUserRole record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysUserRole record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
