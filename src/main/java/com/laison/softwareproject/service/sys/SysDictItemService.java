package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDictItem;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDictItemService 
 * @Description: 实现类 SysDictItemServiceImpl
 * @author lihua
 * @date  2023-03-27 16:40:28
 */
public interface SysDictItemService extends BaseService<SysDictItem,String>{
	
    /**
	 *  CACHE_NAME     SysDictItem
	 */
	public final static String CACHE_NAME = "SysDictItem";
	
	/**
	 * 查询符合条件的 SysDictItem的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDictItem
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDictItem
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDictItem
	 * @param SysDictItem record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDictItem record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDictItem
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDictItem>
	 * @throws Exception
	 */
	List<SysDictItem> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDictItem
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDictItem>
	 * @throws Exception
	 */
	PageInfo<SysDictItem> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDictItem
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDictItem  record
	 * @throws Exception
	 */
	SysDictItem selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDictItem
	 * @param String id
	 * @return  SysDictItem  record
	 * @throws Exception
	 */
	SysDictItem selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDictItem 更新为SysDictItem  record
	 * @param String id
	 * @return  SysDictItem  record
	 * @throws Exception
	 */
	int updateByCondition(SysDictItem record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDictItem
	 * @param SysDictItem record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDictItem record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
