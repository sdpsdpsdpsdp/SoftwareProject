package com.laison.softwareproject.dao.sys;

import com.laison.softwareproject.model.sys.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author lihua  496583747@qq.com
 * @date 2023-03-27 16:43:20
 */
@org.apache.ibatis.annotations.Mapper
public interface SysUserDao extends Mapper<SysUser> {

    @Select("SELECT * FROM sys_user WHERE username = #{username} LIMIT 1")
    SysUser selectOneByUsername(@Param("username") String username);
}