package com.laison.softwareproject.service;


import com.laison.softwareproject.common.api.dto.LogDTO;
import com.laison.softwareproject.model.sys.SysUser;

/**
 * common接口
 *
 * @author: jeecg-boot
 */
public interface BaseCommonService {

    /**
     * 保存日志
     *
     * @param logDTO
     */
    void addLog(LogDTO logDTO);

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
