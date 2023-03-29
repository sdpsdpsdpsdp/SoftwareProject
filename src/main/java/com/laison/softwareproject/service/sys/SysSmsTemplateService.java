package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysSmsTemplate;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysSmsTemplateService 
 * @Description: 实现类 SysSmsTemplateServiceImpl
 * @author lihua
 * @date  2023-03-29 14:11:22
 */
public interface SysSmsTemplateService extends BaseService<SysSmsTemplate,String>{
	
    /**
	 *  CACHE_NAME     SysSmsTemplate
	 */
	public final static String CACHE_NAME = "SysSmsTemplate";
	
	/**
	 * 查询符合条件的 SysSmsTemplate的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysSmsTemplate
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysSmsTemplate
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysSmsTemplate
	 * @param SysSmsTemplate record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysSmsTemplate record) throws Exception;

	/**
	 * 查询所有符合条件的  SysSmsTemplate
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysSmsTemplate>
	 * @throws Exception
	 */
	List<SysSmsTemplate> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysSmsTemplate
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysSmsTemplate>
	 * @throws Exception
	 */
	PageInfo<SysSmsTemplate> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysSmsTemplate
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysSmsTemplate  record
	 * @throws Exception
	 */
	SysSmsTemplate selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysSmsTemplate
	 * @param String id
	 * @return  SysSmsTemplate  record
	 * @throws Exception
	 */
	SysSmsTemplate selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysSmsTemplate 更新为SysSmsTemplate  record
	 * @param String id
	 * @return  SysSmsTemplate  record
	 * @throws Exception
	 */
	int updateByCondition(SysSmsTemplate record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysSmsTemplate
	 * @param SysSmsTemplate record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysSmsTemplate record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
