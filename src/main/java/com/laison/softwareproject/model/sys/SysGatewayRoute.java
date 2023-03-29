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
 * @date  2023-03-29 14:10:47
 * 从 sys_gateway_route 表 自动生成的entity.
 */
@Table(name="sys_gateway_route")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysGatewayRoute implements Serializable {
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
     *   路由ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "路由ID 不能为空") */ 
    @ApiModelProperty(value="路由ID  ")
	private String routerId;
	
	
	/**
     *   服务名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "服务名 不能为空") */ 
    @ApiModelProperty(value="服务名  ")
	private String name;
	
	
	/**
     *   服务地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "服务地址 不能为空") */ 
    @ApiModelProperty(value="服务地址  ")
	private String uri;
	
	
	/**
     *   断言
     */
	/** @NotNull(groups = {AddGroup.class }, message = "断言 不能为空") */ 
    @ApiModelProperty(value="断言  ")
	private String predicates;
	
	
	/**
     *   过滤器
     */
	/** @NotNull(groups = {AddGroup.class }, message = "过滤器 不能为空") */ 
    @ApiModelProperty(value="过滤器  ")
	private String filters;
	
	
	/**
     *   是否重试:0-否 1-是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否重试:0-否 1-是 不能为空") */ 
    @ApiModelProperty(value="是否重试:0-否 1-是  ")
	private Integer retryable;
	
	
	/**
     *   是否忽略前缀0-否 1-是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否忽略前缀0-否 1-是 不能为空") */ 
    @ApiModelProperty(value="是否忽略前缀0-否 1-是  ")
	private Integer stripPrefix;
	
	
	/**
     *   是否为保留数据:0-否 1-是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否为保留数据:0-否 1-是 不能为空") */ 
    @ApiModelProperty(value="是否为保留数据:0-否 1-是  ")
	private Integer persistable;
	
	
	/**
     *   是否在接口文档中展示:0-否 1-是
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否在接口文档中展示:0-否 1-是 不能为空") */ 
    @ApiModelProperty(value="是否在接口文档中展示:0-否 1-是  ")
	private Integer showApi;
	
	
	/**
     *   状态:0-无效 1-有效
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态:0-无效 1-有效 不能为空") */ 
    @ApiModelProperty(value="状态:0-无效 1-有效  ")
	private Integer status;
	
	
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
	
	


	
}