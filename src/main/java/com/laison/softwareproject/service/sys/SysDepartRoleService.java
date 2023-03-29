package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDepartRole;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDepartRoleService 
 * @Description: 实现类 SysDepartRoleServiceImpl
 * @author lihua
 * @date  2023-03-27 16:38:53
 */
public interface SysDepartRoleService extends BaseService<SysDepartRole,String>{
	
    /**
	 *  CACHE_NAME     SysDepartRole
	 */
	public final static String CACHE_NAME = "SysDepartRole";
	
	/**
	 * 查询符合条件的 SysDepartRole的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDepartRole
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDepartRole
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDepartRole
	 * @param SysDepartRole record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDepartRole record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDepartRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDepartRole>
	 * @throws Exception
	 */
	List<SysDepartRole> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDepartRole
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDepartRole>
	 * @throws Exception
	 */
	PageInfo<SysDepartRole> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDepartRole
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDepartRole  record
	 * @throws Exception
	 */
	SysDepartRole selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDepartRole
	 * @param String id
	 * @return  SysDepartRole  record
	 * @throws Exception
	 */
	SysDepartRole selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDepartRole 更新为SysDepartRole  record
	 * @param String id
	 * @return  SysDepartRole  record
	 * @throws Exception
	 */
	int updateByCondition(SysDepartRole record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDepartRole
	 * @param SysDepartRole record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDepartRole record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
