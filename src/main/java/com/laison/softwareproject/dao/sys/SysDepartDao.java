package com.laison.softwareproject.dao.sys;
import com.laison.softwareproject.model.sys.SysDepart;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lihua  496583747@qq.com
 * @date  2023-03-27 16:38:10
 */
@org.apache.ibatis.annotations.Mapper
public interface SysDepartDao extends Mapper<SysDepart>{

    List<SysDepart> queryUserDeparts(String id);
}