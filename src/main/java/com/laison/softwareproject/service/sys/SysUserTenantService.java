package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysUserTenant;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysUserTenantService 
 * @Description: 实现类 SysUserTenantServiceImpl
 * @author lihua
 * @date  2023-03-27 16:44:11
 */
public interface SysUserTenantService extends BaseService<SysUserTenant,String>{
	
    /**
	 *  CACHE_NAME     SysUserTenant
	 */
	public final static String CACHE_NAME = "SysUserTenant";
	
	/**
	 * 查询符合条件的 SysUserTenant的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysUserTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysUserTenant
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysUserTenant
	 * @param SysUserTenant record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysUserTenant record) throws Exception;

	/**
	 * 查询所有符合条件的  SysUserTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysUserTenant>
	 * @throws Exception
	 */
	List<SysUserTenant> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysUserTenant
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysUserTenant>
	 * @throws Exception
	 */
	PageInfo<SysUserTenant> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysUserTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysUserTenant  record
	 * @throws Exception
	 */
	SysUserTenant selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysUserTenant
	 * @param String id
	 * @return  SysUserTenant  record
	 * @throws Exception
	 */
	SysUserTenant selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysUserTenant 更新为SysUserTenant  record
	 * @param String id
	 * @return  SysUserTenant  record
	 * @throws Exception
	 */
	int updateByCondition(SysUserTenant record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysUserTenant
	 * @param SysUserTenant record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysUserTenant record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
