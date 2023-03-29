package com.laison.softwareproject.service.sys;

import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.model.sys.SysFiles;
import com.laison.softwareproject.service.BaseService;

import java.util.HashMap;
import java.util.List;


/**
 * @author lihua
 * @ClassName: SysFilesService
 * @Description: 实现类 SysFilesServiceImpl
 * @date 2023-03-27 16:43:20
 */
public interface SysFilesService extends BaseService<SysFiles, String> {

    /**
     * CACHE_NAME     SysFiles
     */
    public final static String CACHE_NAME = "SysFiles";

    /**
     * 查询符合条件的 SysFiles的个数
     *
     * @param HashMap<String, Object> condition 条件
     * @return int count
     * @throws Exception
     */
    int countByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 删除符合条件的 SysFiles
     *
     * @param HashMap<String, Object> condition 条件
     * @return 成功删除的个数
     * @throws Exception
     */
    int deleteByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键删除 SysFiles
     *
     * @param String id
     * @return 成功删除的个数
     * @throws Exception
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 保存 SysFiles
     *
     * @param SysFiles record
     * @return 成功保存的个数
     * @throws Exception
     */
    int save(SysFiles record) throws Exception;

    /**
     * 查询所有符合条件的  SysFiles
     *
     * @param HashMap<String, Object> condition 条件
     * @return List<SysFiles>
     * @throws Exception
     */
    List<SysFiles> selectAllByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 分页查询所有符合条件的  SysFiles
     *
     * @param HashMap<String, Object> condition 条件 Integer pageNum 从1开始, Integer pageSize
     * @return PageInfo<SysFiles>
     * @throws Exception
     */
    PageInfo<SysFiles> selectPageByCondition(HashMap<String, Object> condition, Integer pageNum, Integer pageSize)
            throws Exception;

    /**
     * 查询所有符合条件的  第一个SysFiles
     *
     * @param HashMap<String, Object> condition 条件
     * @return SysFiles  record
     * @throws Exception
     */
    SysFiles selectFirstByCondition(HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键查询 SysFiles
     *
     * @param String id
     * @return SysFiles  record
     * @throws Exception
     */
    SysFiles selectByPrimaryKey(String id) throws Exception;

    /**
     * 将所有符合条件的SysFiles 更新为SysFiles  record
     *
     * @param String id
     * @return SysFiles  record
     * @throws Exception
     */
    int updateByCondition(SysFiles record, HashMap<String, Object> condition) throws Exception;

    /**
     * 根据主键更新 SysFiles
     *
     * @param SysFiles record
     * @return 更新成功的个数
     * @throws Exception
     */
    int updateByPrimaryKey(SysFiles record) throws Exception;


    /**
     * 删除所有主键在List<String> ids的记录
     *
     * @param List<String> ids
     * @return 更新成功的个数
     * @throws Exception
     */
    int deleteByPrimaryKeys(List<String> ids) throws Exception;
}
