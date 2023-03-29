package com.laison.softwareproject.service.sys;
import java.util.HashMap;
import java.util.List;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysGatewayRoute;
import com.laison.softwareproject.service.BaseService;


/**
 * 
 * @ClassName: SysGatewayRouteService 
 * @Description: 实现类 SysGatewayRouteServiceImpl
 * @author lihua
 * @date  2023-03-29 14:10:47
 */
public interface SysGatewayRouteService extends BaseService<SysGatewayRoute,String>{
	
    /**
	 *  CACHE_NAME     SysGatewayRoute
	 */
	public final static String CACHE_NAME = "SysGatewayRoute";
	
	/**
	 * 查询符合条件的 SysGatewayRoute的个数
	 * @param HashMap<String, Object> condition 条件
	 * @return int count
	 * @throws Exception
	 */
	int countByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 删除符合条件的 SysGatewayRoute
	 * @param HashMap<String, Object> condition 条件
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键删除 SysGatewayRoute
	 * @param String id
	 * @return 成功删除的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String id) throws Exception;

	/**
	 * 保存 SysGatewayRoute
	 * @param SysGatewayRoute record
	 * @return  成功保存的个数
	 * @throws Exception
	 */
	int save(SysGatewayRoute record) throws Exception;

	/**
	 * 查询所有符合条件的  SysGatewayRoute
	 * @param HashMap<String, Object> condition 条件
	 * @return  List<SysGatewayRoute>
	 * @throws Exception
	 */
	List<SysGatewayRoute> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 分页查询所有符合条件的  SysGatewayRoute
	 * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
	 * @return  PageInfo<SysGatewayRoute>
	 * @throws Exception
	 */
	PageInfo<SysGatewayRoute> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
			throws Exception;

	/**
	 * 查询所有符合条件的  第一个SysGatewayRoute
	 * @param HashMap<String, Object> condition 条件
	 * @return  SysGatewayRoute  record
	 * @throws Exception
	 */
	SysGatewayRoute selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键查询 SysGatewayRoute
	 * @param String id
	 * @return  SysGatewayRoute  record
	 * @throws Exception
	 */
	SysGatewayRoute selectByPrimaryKey(String id) throws Exception;

	/**
	 * 将所有符合条件的SysGatewayRoute 更新为SysGatewayRoute  record
	 * @param String id
	 * @return  SysGatewayRoute  record
	 * @throws Exception
	 */
	int updateByCondition(SysGatewayRoute record, HashMap<String, Object> condition) throws Exception;

	/**
	 * 根据主键更新 SysGatewayRoute
	 * @param SysGatewayRoute record
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int updateByPrimaryKey(SysGatewayRoute record) throws Exception;

	
	/**
	 * 删除所有主键在List<String> ids的记录
	 * @param List<String> ids
	 * @return  更新成功的个数
	 * @throws Exception
	 */
	int deleteByPrimaryKeys(List<String> ids) throws Exception;

}
