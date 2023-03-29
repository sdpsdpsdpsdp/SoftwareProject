package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysRoleIndex;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysRoleIndexService 
 * @Description: 实现类 SysRoleIndexServiceImpl
 * @author lihua
 * @date  2023-03-27 16:41:48
 */
public interface SysRoleIndexService extends BaseService<SysRoleIndex,String>{
	
    /**
	 *  CACHE_NAME     SysRoleIndex
	 */
	public final static String CACHE_NAME = "SysRoleIndex";
	
	/**
	 * 查询符合条件的 SysRoleIndex的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysRoleIndex
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysRoleIndex
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysRoleIndex
	 * @param SysRoleIndex record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysRoleIndex record) throws Exception;

	/**
	 * 查询所有符合条件的  SysRoleIndex
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysRoleIndex>
	 * @throws Exception
	 */
	List<SysRoleIndex> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysRoleIndex
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysRoleIndex>
	 * @throws Exception
	 */
	PageInfo<SysRoleIndex> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysRoleIndex
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysRoleIndex  record
	 * @throws Exception
	 */
	SysRoleIndex selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysRoleIndex
	 * @param String id
	 * @return  SysRoleIndex  record
	 * @throws Exception
	 */
	SysRoleIndex selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysRoleIndex 更新为SysRoleIndex  record
	 * @param String id
	 * @return  SysRoleIndex  record
	 * @throws Exception
	 */
	int updateByCondition(SysRoleIndex record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysRoleIndex
	 * @param SysRoleIndex record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysRoleIndex record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
