package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysFormFile;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysFormFileService 
 * @Description: 实现类 SysFormFileServiceImpl
 * @author lihua
 * @date  2023-03-29 14:10:28
 */
public interface SysFormFileService extends BaseService<SysFormFile,String>{
	
    /**
	 *  CACHE_NAME     SysFormFile
	 */
	public final static String CACHE_NAME = "SysFormFile";
	
	/**
	 * 查询符合条件的 SysFormFile的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysFormFile
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysFormFile
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysFormFile
	 * @param SysFormFile record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysFormFile record) throws Exception;

	/**
	 * 查询所有符合条件的  SysFormFile
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysFormFile>
	 * @throws Exception
	 */
	List<SysFormFile> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysFormFile
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysFormFile>
	 * @throws Exception
	 */
	PageInfo<SysFormFile> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysFormFile
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysFormFile  record
	 * @throws Exception
	 */
	SysFormFile selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysFormFile
	 * @param String id
	 * @return  SysFormFile  record
	 * @throws Exception
	 */
	SysFormFile selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysFormFile 更新为SysFormFile  record
	 * @param String id
	 * @return  SysFormFile  record
	 * @throws Exception
	 */
	int updateByCondition(SysFormFile record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysFormFile
	 * @param SysFormFile record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysFormFile record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
