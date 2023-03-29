package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysComment;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysCommentService 
 * @Description: 实现类 SysCommentServiceImpl
 * @author lihua
 * @date  2023-03-29 14:09:01
 */
public interface SysCommentService extends BaseService<SysComment,String>{
	
    /**
	 *  CACHE_NAME     SysComment
	 */
	public final static String CACHE_NAME = "SysComment";
	
	/**
	 * 查询符合条件的 SysComment的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysComment
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysComment
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysComment
	 * @param SysComment record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysComment record) throws Exception;

	/**
	 * 查询所有符合条件的  SysComment
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysComment>
	 * @throws Exception
	 */
	List<SysComment> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysComment
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysComment>
	 * @throws Exception
	 */
	PageInfo<SysComment> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysComment
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysComment  record
	 * @throws Exception
	 */
	SysComment selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysComment
	 * @param String id
	 * @return  SysComment  record
	 * @throws Exception
	 */
	SysComment selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysComment 更新为SysComment  record
	 * @param String id
	 * @return  SysComment  record
	 * @throws Exception
	 */
	int updateByCondition(SysComment record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysComment
	 * @param SysComment record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysComment record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
