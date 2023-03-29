package com.laison.softwareproject.model.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.laison.softwareproject.common.constants.ContentConstant;
import com.laison.softwareproject.common.validatgroup.AddGroup;
import com.laison.softwareproject.common.validatgroup.FindGroup;
import com.laison.softwareproject.common.validatgroup.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import com.laison.softwareproject.common.utils.MyIDGenId;
import tk.mybatis.mapper.annotation.KeySql;
/**
 * @author lihua
 * @date  2023-03-29 14:09:40
 * 从 sys_data_source 表 自动生成的entity.
 */
@Table(name="sys_data_source")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysDataSource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="  ")
	private String id;
	
	
	/**
     *   数据源编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据源编码 不能为空") */ 
    @ApiModelProperty(value="数据源编码  ")
	private String code;
	
	
	/**
     *   数据源名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据源名称 不能为空") */ 
    @ApiModelProperty(value="数据源名称  ")
	private String name;
	
	
	/**
     *   备注
     */
	/** @NotNull(groups = {AddGroup.class }, message = "备注 不能为空") */ 
    @ApiModelProperty(value="备注  ")
	private String remark;
	
	
	/**
     *   数据库类型
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据库类型 不能为空") */ 
    @ApiModelProperty(value="数据库类型  ")
	private String dbType;
	
	
	/**
     *   驱动类
     */
	/** @NotNull(groups = {AddGroup.class }, message = "驱动类 不能为空") */ 
    @ApiModelProperty(value="驱动类  ")
	private String dbDriver;
	
	
	/**
     *   数据源地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据源地址 不能为空") */ 
    @ApiModelProperty(value="数据源地址  ")
	private String dbUrl;
	
	
	/**
     *   数据库名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据库名称 不能为空") */ 
    @ApiModelProperty(value="数据库名称  ")
	private String dbName;
	
	
	/**
     *   用户名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "用户名 不能为空") */ 
    @ApiModelProperty(value="用户名  ")
	private String dbUsername;
	
	
	/**
     *   密码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "密码 不能为空") */ 
    @ApiModelProperty(value="密码  ")
	private String dbPassword;
	
	
	/**
     *   创建人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建人 不能为空") */ 
    @ApiModelProperty(value="创建人  ")
	private String createBy;
	
	
	/**
     *   创建日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建日期 不能为空") */ 
    @ApiModelProperty(value="创建日期  ")
	private Date createTime;
	
	
	/**
     *   更新人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人 不能为空") */ 
    @ApiModelProperty(value="更新人  ")
	private String updateBy;
	
	
	/**
     *   更新日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新日期 不能为空") */ 
    @ApiModelProperty(value="更新日期  ")
	private Date updateTime;
	
	
	/**
     *   所属部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属部门 不能为空") */ 
    @ApiModelProperty(value="所属部门  ")
	private String sysOrgCode;
	
	
	/**
     *   租户ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户ID 不能为空") */ 
    @ApiModelProperty(value="租户ID  ")
	private Integer tenantId;
	
	


	
}