package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysTenantPackUser;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysTenantPackUserService 
 * @Description: 实现类 SysTenantPackUserServiceImpl
 * @author lihua
 * @date  2023-03-27 16:42:54
 */
public interface SysTenantPackUserService extends BaseService<SysTenantPackUser,String>{
	
    /**
	 *  CACHE_NAME     SysTenantPackUser
	 */
	public final static String CACHE_NAME = "SysTenantPackUser";
	
	/**
	 * 查询符合条件的 SysTenantPackUser的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysTenantPackUser
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysTenantPackUser
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysTenantPackUser
	 * @param SysTenantPackUser record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysTenantPackUser record) throws Exception;

	/**
	 * 查询所有符合条件的  SysTenantPackUser
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysTenantPackUser>
	 * @throws Exception
	 */
	List<SysTenantPackUser> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysTenantPackUser
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysTenantPackUser>
	 * @throws Exception
	 */
	PageInfo<SysTenantPackUser> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysTenantPackUser
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysTenantPackUser  record
	 * @throws Exception
	 */
	SysTenantPackUser selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysTenantPackUser
	 * @param String id
	 * @return  SysTenantPackUser  record
	 * @throws Exception
	 */
	SysTenantPackUser selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysTenantPackUser 更新为SysTenantPackUser  record
	 * @param String id
	 * @return  SysTenantPackUser  record
	 * @throws Exception
	 */
	int updateByCondition(SysTenantPackUser record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysTenantPackUser
	 * @param SysTenantPackUser record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysTenantPackUser record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
