package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysPosition;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysPositionService 
 * @Description: 实现类 SysPositionServiceImpl
 * @author lihua
 * @date  2023-03-27 16:41:21
 */
public interface SysPositionService extends BaseService<SysPosition,String>{
	
    /**
	 *  CACHE_NAME     SysPosition
	 */
	public final static String CACHE_NAME = "SysPosition";
	
	/**
	 * 查询符合条件的 SysPosition的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysPosition
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysPosition
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysPosition
	 * @param SysPosition record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysPosition record) throws Exception;

	/**
	 * 查询所有符合条件的  SysPosition
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysPosition>
	 * @throws Exception
	 */
	List<SysPosition> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysPosition
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysPosition>
	 * @throws Exception
	 */
	PageInfo<SysPosition> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysPosition
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysPosition  record
	 * @throws Exception
	 */
	SysPosition selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysPosition
	 * @param String id
	 * @return  SysPosition  record
	 * @throws Exception
	 */
	SysPosition selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysPosition 更新为SysPosition  record
	 * @param String id
	 * @return  SysPosition  record
	 * @throws Exception
	 */
	int updateByCondition(SysPosition record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysPosition
	 * @param SysPosition record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysPosition record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
