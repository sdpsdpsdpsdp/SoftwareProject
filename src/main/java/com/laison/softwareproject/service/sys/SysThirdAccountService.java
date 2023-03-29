package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysThirdAccount;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysThirdAccountService 
 * @Description: 实现类 SysThirdAccountServiceImpl
 * @author lihua
 * @date  2023-03-27 16:43:08
 */
public interface SysThirdAccountService extends BaseService<SysThirdAccount,String>{
	
    /**
	 *  CACHE_NAME     SysThirdAccount
	 */
	public final static String CACHE_NAME = "SysThirdAccount";
	
	/**
	 * 查询符合条件的 SysThirdAccount的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysThirdAccount
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysThirdAccount
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysThirdAccount
	 * @param SysThirdAccount record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysThirdAccount record) throws Exception;

	/**
	 * 查询所有符合条件的  SysThirdAccount
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysThirdAccount>
	 * @throws Exception
	 */
	List<SysThirdAccount> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysThirdAccount
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysThirdAccount>
	 * @throws Exception
	 */
	PageInfo<SysThirdAccount> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysThirdAccount
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysThirdAccount  record
	 * @throws Exception
	 */
	SysThirdAccount selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysThirdAccount
	 * @param String id
	 * @return  SysThirdAccount  record
	 * @throws Exception
	 */
	SysThirdAccount selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysThirdAccount 更新为SysThirdAccount  record
	 * @param String id
	 * @return  SysThirdAccount  record
	 * @throws Exception
	 */
	int updateByCondition(SysThirdAccount record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysThirdAccount
	 * @param SysThirdAccount record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysThirdAccount record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
