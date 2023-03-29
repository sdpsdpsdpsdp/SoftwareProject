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
 * @date  2023-03-27 16:41:05
 * 从 sys_permission_v2 表 自动生成的entity.
 */
@Table(name="sys_permission_v2")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysPermissionV2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   主键id
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="主键id  ")
	private String id;
	
	
	/**
     *   父id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "父id 不能为空") */ 
    @ApiModelProperty(value="父id  ")
	private String parentId;
	
	
	/**
     *   菜单标题
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单标题 不能为空") */ 
    @ApiModelProperty(value="菜单标题  ")
	private String name;
	
	
	/**
     *   路径
     */
	/** @NotNull(groups = {AddGroup.class }, message = "路径 不能为空") */ 
    @ApiModelProperty(value="路径  ")
	private String url;
	
	
	/**
     *   组件
     */
	/** @NotNull(groups = {AddGroup.class }, message = "组件 不能为空") */ 
    @ApiModelProperty(value="组件  ")
	private String component;
	
	
	/**
     *   组件名字
     */
	/** @NotNull(groups = {AddGroup.class }, message = "组件名字 不能为空") */ 
    @ApiModelProperty(value="组件名字  ")
	private String componentName;
	
	
	/**
     *   一级菜单跳转地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "一级菜单跳转地址 不能为空") */ 
    @ApiModelProperty(value="一级菜单跳转地址  ")
	private String redirect;
	
	
	/**
     *   菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单类型(0:一级菜单; 1:子菜单:2:按钮权限) 不能为空") */ 
    @ApiModelProperty(value="菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)  ")
	private Integer menuType;
	
	
	/**
     *   菜单权限编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单权限编码 不能为空") */ 
    @ApiModelProperty(value="菜单权限编码  ")
	private String perms;
	
	
	/**
     *   权限策略1显示2禁用
     */
	/** @NotNull(groups = {AddGroup.class }, message = "权限策略1显示2禁用 不能为空") */ 
    @ApiModelProperty(value="权限策略1显示2禁用  ")
	private String permsType;
	
	
	/**
     *   菜单排序
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单排序 不能为空") */ 
    @ApiModelProperty(value="菜单排序  ")
	private String sortNo;
	
	
	/**
     *   聚合子路由: 1是0否
     */
	/** @NotNull(groups = {AddGroup.class }, message = "聚合子路由: 1是0否 不能为空") */ 
    @ApiModelProperty(value="聚合子路由: 1是0否  ")
	private Boolean alwaysShow;
	
	
	/**
     *   菜单图标
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单图标 不能为空") */ 
    @ApiModelProperty(value="菜单图标  ")
	private String icon;
	
	
	/**
     *   是否路由菜单: 0:不是  1:是（默认值1）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否路由菜单: 0:不是  1:是（默认值1） 不能为空") */ 
    @ApiModelProperty(value="是否路由菜单: 0:不是  1:是（默认值1）  ")
	private Boolean isRoute;
	
	
	/**
     *   是否叶子节点:    1:是   0:不是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否叶子节点:    1:是   0:不是 不能为空") */ 
    @ApiModelProperty(value="是否叶子节点:    1:是   0:不是  ")
	private Boolean isLeaf;
	
	
	/**
     *   是否缓存该页面:    1:是   0:不是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否缓存该页面:    1:是   0:不是 不能为空") */ 
    @ApiModelProperty(value="是否缓存该页面:    1:是   0:不是  ")
	private Boolean keepAlive;
	
	
	/**
     *   是否隐藏路由: 0否,1是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否隐藏路由: 0否,1是 不能为空") */ 
    @ApiModelProperty(value="是否隐藏路由: 0否,1是  ")
	private Boolean hidden;
	
	
	/**
     *   是否隐藏tab: 0否,1是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否隐藏tab: 0否,1是 不能为空") */ 
    @ApiModelProperty(value="是否隐藏tab: 0否,1是  ")
	private Boolean hideTab;
	
	
	/**
     *   描述
     */
	/** @NotNull(groups = {AddGroup.class }, message = "描述 不能为空") */ 
    @ApiModelProperty(value="描述  ")
	private String description;
	
	
	/**
     *   外链菜单打开方式 0/内部打开 1/外部打开
     */
	/** @NotNull(groups = {AddGroup.class }, message = "外链菜单打开方式 0/内部打开 1/外部打开 不能为空") */ 
    @ApiModelProperty(value="外链菜单打开方式 0/内部打开 1/外部打开  ")
	private Boolean internalOrExternal;
	
	
	/**
     *   是否添加数据权限1是0否
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否添加数据权限1是0否 不能为空") */ 
    @ApiModelProperty(value="是否添加数据权限1是0否  ")
	private Integer ruleFlag;
	
	
	/**
     *   按钮权限状态(0无效1有效)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "按钮权限状态(0无效1有效) 不能为空") */ 
    @ApiModelProperty(value="按钮权限状态(0无效1有效)  ")
	private String status;
	
	
	/**
     *   删除状态 0正常 1已删除
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态 0正常 1已删除 不能为空") */ 
    @ApiModelProperty(value="删除状态 0正常 1已删除  ")
	private Integer delFlag;
	
	
	/**
     *   创建人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建人 不能为空") */ 
    @ApiModelProperty(value="创建人  ")
	private String createBy;
	
	
	/**
     *   创建时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建时间 不能为空") */ 
    @ApiModelProperty(value="创建时间  ")
	private Date createTime;
	
	
	/**
     *   更新人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人 不能为空") */ 
    @ApiModelProperty(value="更新人  ")
	private String updateBy;
	
	
	/**
     *   更新时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新时间 不能为空") */ 
    @ApiModelProperty(value="更新时间  ")
	private Date updateTime;
	
	


	
}