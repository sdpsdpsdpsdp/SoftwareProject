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
 * @date  2023-03-27 16:40:39
 * 从 sys_log 表 自动生成的entity.
 */
@Table(name="sys_log")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysLog implements Serializable {
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
     *   日志类型（1登录日志，2操作日志, 3.租户操作日志）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "日志类型（1登录日志，2操作日志, 3.租户操作日志） 不能为空") */ 
    @ApiModelProperty(value="日志类型（1登录日志，2操作日志, 3.租户操作日志）  ")
	private Integer logType;
	
	
	/**
     *   日志内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "日志内容 不能为空") */ 
    @ApiModelProperty(value="日志内容  ")
	private String logContent;
	
	
	/**
     *   操作类型
     */
	/** @NotNull(groups = {AddGroup.class }, message = "操作类型 不能为空") */ 
    @ApiModelProperty(value="操作类型  ")
	private Integer operateType;
	
	
	/**
     *   操作用户账号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "操作用户账号 不能为空") */ 
    @ApiModelProperty(value="操作用户账号  ")
	private String userid;
	
	
	/**
     *   操作用户名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "操作用户名称 不能为空") */ 
    @ApiModelProperty(value="操作用户名称  ")
	private String username;
	
	
	/**
     *   IP
     */
	/** @NotNull(groups = {AddGroup.class }, message = "IP 不能为空") */ 
    @ApiModelProperty(value="IP  ")
	private String ip;
	
	
	/**
     *   请求java方法
     */
	/** @NotNull(groups = {AddGroup.class }, message = "请求java方法 不能为空") */ 
    @ApiModelProperty(value="请求java方法  ")
	private String method;
	
	
	/**
     *   请求路径
     */
	/** @NotNull(groups = {AddGroup.class }, message = "请求路径 不能为空") */ 
    @ApiModelProperty(value="请求路径  ")
	private String requestUrl;
	
	
	/**
     *   请求参数
     */
	/** @NotNull(groups = {AddGroup.class }, message = "请求参数 不能为空") */ 
    @ApiModelProperty(value="请求参数  ")
	private String requestParam;
	
	
	/**
     *   请求类型
     */
	/** @NotNull(groups = {AddGroup.class }, message = "请求类型 不能为空") */ 
    @ApiModelProperty(value="请求类型  ")
	private String requestType;
	
	
	/**
     *   耗时
     */
	/** @NotNull(groups = {AddGroup.class }, message = "耗时 不能为空") */ 
    @ApiModelProperty(value="耗时  ")
	private Long costTime;
	
	
	/**
     *   租户ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户ID 不能为空") */ 
    @ApiModelProperty(value="租户ID  ")
	private Integer tenantId;
	
	
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