package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDepartPermission;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDepartPermissionService 
 * @Description: 实现类 SysDepartPermissionServiceImpl
 * @author lihua
 * @date  2023-03-27 16:38:23
 */
public interface SysDepartPermissionService extends BaseService<SysDepartPermission,String>{
	
    /**
	 *  CACHE_NAME     SysDepartPermission
	 */
	public final static String CACHE_NAME = "SysDepartPermission";
	
	/**
	 * 查询符合条件的 SysDepartPermission的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDepartPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDepartPermission
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDepartPermission
	 * @param SysDepartPermission record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDepartPermission record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDepartPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDepartPermission>
	 * @throws Exception
	 */
	List<SysDepartPermission> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDepartPermission
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDepartPermission>
	 * @throws Exception
	 */
	PageInfo<SysDepartPermission> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDepartPermission
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDepartPermission  record
	 * @throws Exception
	 */
	SysDepartPermission selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDepartPermission
	 * @param String id
	 * @return  SysDepartPermission  record
	 * @throws Exception
	 */
	SysDepartPermission selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDepartPermission 更新为SysDepartPermission  record
	 * @param String id
	 * @return  SysDepartPermission  record
	 * @throws Exception
	 */
	int updateByCondition(SysDepartPermission record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDepartPermission
	 * @param SysDepartPermission record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDepartPermission record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
