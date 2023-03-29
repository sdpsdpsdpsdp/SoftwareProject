package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysSms;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysSmsService 
 * @Description: 实现类 SysSmsServiceImpl
 * @author lihua
 * @date  2023-03-29 14:11:08
 */
public interface SysSmsService extends BaseService<SysSms,String>{
	
    /**
	 *  CACHE_NAME     SysSms
	 */
	public final static String CACHE_NAME = "SysSms";
	
	/**
	 * 查询符合条件的 SysSms的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysSms
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysSms
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysSms
	 * @param SysSms record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysSms record) throws Exception;

	/**
	 * 查询所有符合条件的  SysSms
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysSms>
	 * @throws Exception
	 */
	List<SysSms> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysSms
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysSms>
	 * @throws Exception
	 */
	PageInfo<SysSms> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysSms
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysSms  record
	 * @throws Exception
	 */
	SysSms selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysSms
	 * @param String id
	 * @return  SysSms  record
	 * @throws Exception
	 */
	SysSms selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysSms 更新为SysSms  record
	 * @param String id
	 * @return  SysSms  record
	 * @throws Exception
	 */
	int updateByCondition(SysSms record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysSms
	 * @param SysSms record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysSms record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
