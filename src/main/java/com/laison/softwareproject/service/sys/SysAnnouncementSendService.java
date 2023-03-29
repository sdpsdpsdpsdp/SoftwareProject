package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysAnnouncementSend;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysAnnouncementSendService 
 * @Description: 实现类 SysAnnouncementSendServiceImpl
 * @author lihua
 * @date  2023-03-29 14:06:44
 */
public interface SysAnnouncementSendService extends BaseService<SysAnnouncementSend,Long>{
	
    /**
	 *  CACHE_NAME     SysAnnouncementSend
	 */
	public final static String CACHE_NAME = "SysAnnouncementSend";
	
	/**
	 * 查询符合条件的 SysAnnouncementSend的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysAnnouncementSend
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysAnnouncementSend
	 * @param Long id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysAnnouncementSend
	 * @param SysAnnouncementSend record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysAnnouncementSend record) throws Exception;

	/**
	 * 查询所有符合条件的  SysAnnouncementSend
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysAnnouncementSend>
	 * @throws Exception
	 */
	List<SysAnnouncementSend> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysAnnouncementSend
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysAnnouncementSend>
	 * @throws Exception
	 */
	PageInfo<SysAnnouncementSend> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysAnnouncementSend
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysAnnouncementSend  record
	 * @throws Exception
	 */
	SysAnnouncementSend selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysAnnouncementSend
	 * @param Long id
	 * @return  SysAnnouncementSend  record
	 * @throws Exception
	 */
	SysAnnouncementSend selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysAnnouncementSend 更新为SysAnnouncementSend  record
	 * @param Long id
	 * @return  SysAnnouncementSend  record
	 * @throws Exception
	 */
	int updateByCondition(SysAnnouncementSend record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysAnnouncementSend
	 * @param SysAnnouncementSend record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysAnnouncementSend record) throws Exception;

	
	/**
	 * 删除所有主键在List<Long> ids的记录
	 * @param List<Long> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
