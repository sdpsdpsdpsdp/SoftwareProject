package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysTenantPack;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysTenantPackService 
 * @Description: 实现类 SysTenantPackServiceImpl
 * @author lihua
 * @date  2023-03-27 16:42:29
 */
public interface SysTenantPackService extends BaseService<SysTenantPack,String>{
	
    /**
	 *  CACHE_NAME     SysTenantPack
	 */
	public final static String CACHE_NAME = "SysTenantPack";
	
	/**
	 * 查询符合条件的 SysTenantPack的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysTenantPack
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysTenantPack
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysTenantPack
	 * @param SysTenantPack record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysTenantPack record) throws Exception;

	/**
	 * 查询所有符合条件的  SysTenantPack
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysTenantPack>
	 * @throws Exception
	 */
	List<SysTenantPack> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysTenantPack
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysTenantPack>
	 * @throws Exception
	 */
	PageInfo<SysTenantPack> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysTenantPack
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysTenantPack  record
	 * @throws Exception
	 */
	SysTenantPack selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysTenantPack
	 * @param String id
	 * @return  SysTenantPack  record
	 * @throws Exception
	 */
	SysTenantPack selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysTenantPack 更新为SysTenantPack  record
	 * @param String id
	 * @return  SysTenantPack  record
	 * @throws Exception
	 */
	int updateByCondition(SysTenantPack record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysTenantPack
	 * @param SysTenantPack record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysTenantPack record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
