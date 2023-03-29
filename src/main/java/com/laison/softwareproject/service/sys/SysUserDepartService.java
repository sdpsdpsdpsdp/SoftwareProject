package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysUserDepart;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysUserDepartService 
 * @Description: 实现类 SysUserDepartServiceImpl
 * @author lihua
 * @date  2023-03-27 16:43:46
 */
public interface SysUserDepartService extends BaseService<SysUserDepart,String>{
	
    /**
	 *  CACHE_NAME     SysUserDepart
	 */
	public final static String CACHE_NAME = "SysUserDepart";
	
	/**
	 * 查询符合条件的 SysUserDepart的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysUserDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysUserDepart
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysUserDepart
	 * @param SysUserDepart record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysUserDepart record) throws Exception;

	/**
	 * 查询所有符合条件的  SysUserDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysUserDepart>
	 * @throws Exception
	 */
	List<SysUserDepart> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysUserDepart
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysUserDepart>
	 * @throws Exception
	 */
	PageInfo<SysUserDepart> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysUserDepart
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysUserDepart  record
	 * @throws Exception
	 */
	SysUserDepart selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysUserDepart
	 * @param String id
	 * @return  SysUserDepart  record
	 * @throws Exception
	 */
	SysUserDepart selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysUserDepart 更新为SysUserDepart  record
	 * @param String id
	 * @return  SysUserDepart  record
	 * @throws Exception
	 */
	int updateByCondition(SysUserDepart record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysUserDepart
	 * @param SysUserDepart record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysUserDepart record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
