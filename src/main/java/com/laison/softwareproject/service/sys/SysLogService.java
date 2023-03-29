package com.laison.softwareproject.service.sys;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.common.api.dto.LogDTO;
import com.laison.softwareproject.model.sys.SysLog;
import com.laison.softwareproject.model.sys.SysUser;
import com.laison.softwareproject.service.BaseService;


/**
 * @author lihua
 * @ClassName: SysLogService
 * @Description: 实现类 SysLogServiceImpl
 * @date 2023-03-27 16:40:39
 */
public interface SysLogService extends BaseService<SysLog, String> {

    /**
     * CACHE_NAME     SysLog
     */
    public final static String CACHE_NAME = "SysLog";

    /**
     * 查询符合条件的 SysLog的个数
     *
     * @param HashMap<String, Object> condition 条件
     * @return int count
     * @throws Exception
     */
    int countByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 删除符合条件的 SysLog
     *
     * @param HashMap<String, Object> condition 条件
     * @return 成功删除的个数
     * @throws Exception
     */
    int deleteByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键删除 SysLog
     *
     * @param String id
     * @return 成功删除的个数
     * @throws Exception
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 保存 SysLog
     *
     * @param SysLog record
     * @return 成功保存的个数
     * @throws Exception
     */
    int save(SysLog record) throws Exception;

    int save(LogDTO record) throws Exception;

    /**
     * 查询所有符合条件的  SysLog
     *
     * @param HashMap<String, Object> condition 条件
     * @return List<SysLog>
     * @throws Exception
     */
    List<SysLog> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 分页查询所有符合条件的  SysLog
     *
     * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
     * @return PageInfo<SysLog>
     * @throws Exception
     */
    PageInfo<SysLog> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
            throws Exception;

    /**
     * 查询所有符合条件的  第一个SysLog
     *
     * @param HashMap<String, Object> condition 条件
     * @return SysLog  record
     * @throws Exception
     */
    SysLog selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键查询 SysLog
     *
     * @param String id
     * @return SysLog  record
     * @throws Exception
     */
    SysLog selectByPrimaryKey(String id) throws Exception;

    /**
     * 将所有符合条件的SysLog 更新为SysLog  record
     *
     * @param String id
     * @return SysLog  record
     * @throws Exception
     */
    int updateByCondition(SysLog record, HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键更新 SysLog
     *
     * @param SysLog record
     * @return 更新成功的个数
     * @throws Exception
     */
    int updateByPrimaryKey(SysLog record) throws Exception;


    /**
     * 删除所有主键在List<String> ids的记录
     *
     * @param List<String> ids
     * @return 更新成功的个数
     * @throws Exception
     */
    int deleteByPrimaryKeys(List<String> ids) throws Exception;


    /**
     * 保存日志
     *
     * @param logDTO
     */
    void addLog(SysLog logDTO);

    /**
     * 保存日志
     *
     * @param logContent
     * @param logType
     * @param operateType
     * @param user
     */
    void addLog(String logContent, Integer logType, Integer operateType, SysUser user);

    /**
     * 保存日志
     *
     * @param logContent
     * @param logType
     * @param operateType
     */
    void addLog(String logContent, Integer logType, Integer operateType);
}
