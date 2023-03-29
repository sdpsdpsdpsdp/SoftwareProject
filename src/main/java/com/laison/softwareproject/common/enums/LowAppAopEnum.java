package com.laison.softwareproject.common.enums;

/**
 * LowApp 切面注解枚举
 * @date 2022-1-5
 * @author: jeecg-boot
 */
public enum LowAppAopEnum {

    /**
     * 新增方法
     */
    ADD,
    /**
     * 删除方法（包含单个和批量删除）
     */
    DELETE,
    /** 复制表单操作 */
    COPY,

    /**
     * Online表单专用：数据库表转Online表单
     */
    CGFORM_DB_IMPORT,

    /**
     * 表单设计器专用：子表转工作表
     */
    DESFORM_SUB2WORK
}