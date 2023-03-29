package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysTenant;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysTenantService 
 * @Description: 实现类 SysTenantServiceImpl
 * @author lihua
 * @date  2023-03-27 16:42:15
 */
public interface SysTenantService extends BaseService<SysTenant,Integer>{
	
    /**
	 *  CACHE_NAME     SysTenant
	 */
	public final static String CACHE_NAME = "SysTenant";
	
	/**
	 * 查询符合条件的 SysTenant的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysTenant
	 * @param Integer id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id) throws Exception;

	/**
	 * 保存 SysTenant
	 * @param SysTenant record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysTenant record) throws Exception;

	/**
	 * 查询所有符合条件的  SysTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysTenant>
	 * @throws Exception
	 */
	List<SysTenant> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysTenant
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysTenant>
	 * @throws Exception
	 */
	PageInfo<SysTenant> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysTenant
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysTenant  record
	 * @throws Exception
	 */
	SysTenant selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysTenant
	 * @param Integer id
	 * @return  SysTenant  record
	 * @throws Exception
	 */
	SysTenant selectByPrimaryKey(Integer id) throws Exception;

	/**
	 * 将所有符合条件的SysTenant 更新为SysTenant  record
	 * @param Integer id
	 * @return  SysTenant  record
	 * @throws Exception
	 */
	int updateByCondition(SysTenant record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysTenant
	 * @param SysTenant record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysTenant record) throws Exception;

	
	/**
	 * 删除所有主键在List<Integer> ids的记录
	 * @param List<Integer> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<Integer> ids) throws Exception;

}
