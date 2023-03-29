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
 * @date  2023-03-27 16:41:48
 * 从 sys_role_index 表 自动生成的entity.
 */
@Table(name="sys_role_index")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysRoleIndex implements Serializable {
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
     *   角色编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "角色编码 不能为空") */ 
    @ApiModelProperty(value="角色编码  ")
	private String roleCode;
	
	
	/**
     *   路由地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "路由地址 不能为空") */ 
    @ApiModelProperty(value="路由地址  ")
	private String url;
	
	
	/**
     *   组件
     */
	/** @NotNull(groups = {AddGroup.class }, message = "组件 不能为空") */ 
    @ApiModelProperty(value="组件  ")
	private String component;
	
	
	/**
     *   是否路由菜单: 0:不是  1:是（默认值1）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否路由菜单: 0:不是  1:是（默认值1） 不能为空") */ 
    @ApiModelProperty(value="是否路由菜单: 0:不是  1:是（默认值1）  ")
	private Boolean isRoute;
	
	
	/**
     *   优先级
     */
	/** @NotNull(groups = {AddGroup.class }, message = "优先级 不能为空") */ 
    @ApiModelProperty(value="优先级  ")
	private Integer priority;
	
	
	/**
     *   所属部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属部门 不能为空") */ 
    @ApiModelProperty(value="所属部门  ")
	private String sysOrgCode;
	
	
	/**
     *   状态0:无效 1:有效
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态0:无效 1:有效 不能为空") */ 
    @ApiModelProperty(value="状态0:无效 1:有效  ")
	private String status;
	
	
	/**
     *   创建人登录名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建人登录名称 不能为空") */ 
    @ApiModelProperty(value="创建人登录名称  ")
	private String createBy;
	
	
	/**
     *   创建日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建日期 不能为空") */ 
    @ApiModelProperty(value="创建日期  ")
	private Date createTime;
	
	
	/**
     *   更新人登录名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人登录名称 不能为空") */ 
    @ApiModelProperty(value="更新人登录名称  ")
	private String updateBy;
	
	
	/**
     *   更新日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新日期 不能为空") */ 
    @ApiModelProperty(value="更新日期  ")
	private Date updateTime;
	
	


	
}