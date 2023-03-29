package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysDepart;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysDepartService 
 * @Description: 实现类 SysDepartServiceImpl
 * @author lihua
 * @date  2023-03-27 16:38:10
 */
public interface SysDepartService extends BaseService<SysDepart,String>{
	
    /**
	 *  CACHE_NAME     SysDepart
	 */
	public final static String CACHE_NAME = "SysDepart";
	
	/**
	 * 查询符合条件的 SysDepart的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysDepart
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysDepart
	 * @param SysDepart record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysDepart record) throws Exception;

	/**
	 * 查询所有符合条件的  SysDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysDepart>
	 * @throws Exception
	 */
	List<SysDepart> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysDepart
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysDepart>
	 * @throws Exception
	 */
	PageInfo<SysDepart> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysDepart  record
	 * @throws Exception
	 */
	SysDepart selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysDepart
	 * @param String id
	 * @return  SysDepart  record
	 * @throws Exception
	 */
	SysDepart selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysDepart 更新为SysDepart  record
	 * @param String id
	 * @return  SysDepart  record
	 * @throws Exception
	 */
	int updateByCondition(SysDepart record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysDepart
	 * @param SysDepart record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysDepart record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
