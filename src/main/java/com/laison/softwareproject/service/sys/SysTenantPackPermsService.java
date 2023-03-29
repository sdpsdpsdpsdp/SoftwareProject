package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysTenantPackPerms;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysTenantPackPermsService 
 * @Description: 实现类 SysTenantPackPermsServiceImpl
 * @author lihua
 * @date  2023-03-27 16:42:41
 */
public interface SysTenantPackPermsService extends BaseService<SysTenantPackPerms,String>{
	
    /**
	 *  CACHE_NAME     SysTenantPackPerms
	 */
	public final static String CACHE_NAME = "SysTenantPackPerms";
	
	/**
	 * 查询符合条件的 SysTenantPackPerms的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysTenantPackPerms
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysTenantPackPerms
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysTenantPackPerms
	 * @param SysTenantPackPerms record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysTenantPackPerms record) throws Exception;

	/**
	 * 查询所有符合条件的  SysTenantPackPerms
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysTenantPackPerms>
	 * @throws Exception
	 */
	List<SysTenantPackPerms> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysTenantPackPerms
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysTenantPackPerms>
	 * @throws Exception
	 */
	PageInfo<SysTenantPackPerms> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysTenantPackPerms
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysTenantPackPerms  record
	 * @throws Exception
	 */
	SysTenantPackPerms selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysTenantPackPerms
	 * @param String id
	 * @return  SysTenantPackPerms  record
	 * @throws Exception
	 */
	SysTenantPackPerms selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysTenantPackPerms 更新为SysTenantPackPerms  record
	 * @param String id
	 * @return  SysTenantPackPerms  record
	 * @throws Exception
	 */
	int updateByCondition(SysTenantPackPerms record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysTenantPackPerms
	 * @param SysTenantPackPerms record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysTenantPackPerms record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
