package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysUserAgent;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysUserAgentService 
 * @Description: 实现类 SysUserAgentServiceImpl
 * @author lihua
 * @date  2023-03-27 16:43:33
 */
public interface SysUserAgentService extends BaseService<SysUserAgent,String>{
	
    /**
	 *  CACHE_NAME     SysUserAgent
	 */
	public final static String CACHE_NAME = "SysUserAgent";
	
	/**
	 * 查询符合条件的 SysUserAgent的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysUserAgent
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysUserAgent
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysUserAgent
	 * @param SysUserAgent record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysUserAgent record) throws Exception;

	/**
	 * 查询所有符合条件的  SysUserAgent
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysUserAgent>
	 * @throws Exception
	 */
	List<SysUserAgent> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysUserAgent
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysUserAgent>
	 * @throws Exception
	 */
	PageInfo<SysUserAgent> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysUserAgent
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysUserAgent  record
	 * @throws Exception
	 */
	SysUserAgent selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysUserAgent
	 * @param String id
	 * @return  SysUserAgent  record
	 * @throws Exception
	 */
	SysUserAgent selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysUserAgent 更新为SysUserAgent  record
	 * @param String id
	 * @return  SysUserAgent  record
	 * @throws Exception
	 */
	int updateByCondition(SysUserAgent record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysUserAgent
	 * @param SysUserAgent record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysUserAgent record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
