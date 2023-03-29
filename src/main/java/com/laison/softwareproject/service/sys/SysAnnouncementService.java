package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysAnnouncement;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysAnnouncementService 
 * @Description: 实现类 SysAnnouncementServiceImpl
 * @author lihua
 * @date  2023-03-29 14:06:27
 */
public interface SysAnnouncementService extends BaseService<SysAnnouncement,String>{
	
    /**
	 *  CACHE_NAME     SysAnnouncement
	 */
	public final static String CACHE_NAME = "SysAnnouncement";
	
	/**
	 * 查询符合条件的 SysAnnouncement的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysAnnouncement
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysAnnouncement
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysAnnouncement
	 * @param SysAnnouncement record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysAnnouncement record) throws Exception;

	/**
	 * 查询所有符合条件的  SysAnnouncement
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysAnnouncement>
	 * @throws Exception
	 */
	List<SysAnnouncement> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysAnnouncement
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysAnnouncement>
	 * @throws Exception
	 */
	PageInfo<SysAnnouncement> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysAnnouncement
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysAnnouncement  record
	 * @throws Exception
	 */
	SysAnnouncement selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysAnnouncement
	 * @param String id
	 * @return  SysAnnouncement  record
	 * @throws Exception
	 */
	SysAnnouncement selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysAnnouncement 更新为SysAnnouncement  record
	 * @param String id
	 * @return  SysAnnouncement  record
	 * @throws Exception
	 */
	int updateByCondition(SysAnnouncement record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysAnnouncement
	 * @param SysAnnouncement record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysAnnouncement record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
