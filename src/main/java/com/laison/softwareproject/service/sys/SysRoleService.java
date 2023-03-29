package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysRole;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysRoleService 
 * @Description: 实现类 SysRoleServiceImpl
 * @author lihua
 * @date  2023-03-27 16:41:34
 */
public interface SysRoleService extends BaseService<SysRole,String>{
	
    /**
	 *  CACHE_NAME     SysRole
	 */
	public final static String CACHE_NAME = "SysRole";
	
	/**
	 * 查询符合条件的 SysRole的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysRole
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysRole
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysRole
	 * @param SysRole record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysRole record) throws Exception;

	/**
	 * 查询所有符合条件的  SysRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysRole>
	 * @throws Exception
	 */
	List<SysRole> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysRole
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysRole>
	 * @throws Exception
	 */
	PageInfo<SysRole> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysRole  record
	 * @throws Exception
	 */
	SysRole selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysRole
	 * @param String id
	 * @return  SysRole  record
	 * @throws Exception
	 */
	SysRole selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysRole 更新为SysRole  record
	 * @param String id
	 * @return  SysRole  record
	 * @throws Exception
	 */
	int updateByCondition(SysRole record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysRole
	 * @param SysRole record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysRole record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
