package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDepartRoleUser;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDepartRoleUserService 
 * @Description: 实现类 SysDepartRoleUserServiceImpl
 * @author lihua
 * @date  2023-03-27 16:39:40
 */
public interface SysDepartRoleUserService extends BaseService<SysDepartRoleUser,String>{
	
    /**
	 *  CACHE_NAME     SysDepartRoleUser
	 */
	public final static String CACHE_NAME = "SysDepartRoleUser";
	
	/**
	 * 查询符合条件的 SysDepartRoleUser的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDepartRoleUser
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDepartRoleUser
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDepartRoleUser
	 * @param SysDepartRoleUser record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDepartRoleUser record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDepartRoleUser
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDepartRoleUser>
	 * @throws Exception
	 */
	List<SysDepartRoleUser> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDepartRoleUser
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDepartRoleUser>
	 * @throws Exception
	 */
	PageInfo<SysDepartRoleUser> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDepartRoleUser
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDepartRoleUser  record
	 * @throws Exception
	 */
	SysDepartRoleUser selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDepartRoleUser
	 * @param String id
	 * @return  SysDepartRoleUser  record
	 * @throws Exception
	 */
	SysDepartRoleUser selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDepartRoleUser 更新为SysDepartRoleUser  record
	 * @param String id
	 * @return  SysDepartRoleUser  record
	 * @throws Exception
	 */
	int updateByCondition(SysDepartRoleUser record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDepartRoleUser
	 * @param SysDepartRoleUser record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDepartRoleUser record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
