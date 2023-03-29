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
 * @date  2023-03-29 14:06:27
 * 从 sys_announcement 表 自动生成的entity.
 */
@Table(name="sys_announcement")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysAnnouncement implements Serializable {
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
     *   标题
     */
	/** @NotNull(groups = {AddGroup.class }, message = "标题 不能为空") */ 
    @ApiModelProperty(value="标题  ")
	private String titile;
	
	
	/**
     *   内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "内容 不能为空") */ 
    @ApiModelProperty(value="内容  ")
	private String msgContent;
	
	
	/**
     *   开始时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "开始时间 不能为空") */ 
    @ApiModelProperty(value="开始时间  ")
	private Date startTime;
	
	
	/**
     *   结束时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "结束时间 不能为空") */ 
    @ApiModelProperty(value="结束时间  ")
	private Date endTime;
	
	
	/**
     *   发布人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发布人 不能为空") */ 
    @ApiModelProperty(value="发布人  ")
	private String sender;
	
	
	/**
     *   优先级（L低，M中，H高）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "优先级（L低，M中，H高） 不能为空") */ 
    @ApiModelProperty(value="优先级（L低，M中，H高）  ")
	private String priority;
	
	
	/**
     *   消息类型1:通知公告2:系统消息
     */
	/** @NotNull(groups = {AddGroup.class }, message = "消息类型1:通知公告2:系统消息 不能为空") */ 
    @ApiModelProperty(value="消息类型1:通知公告2:系统消息  ")
	private String msgCategory;
	
	
	/**
     *   通告对象类型（USER:指定用户，ALL:全体用户）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "通告对象类型（USER:指定用户，ALL:全体用户） 不能为空") */ 
    @ApiModelProperty(value="通告对象类型（USER:指定用户，ALL:全体用户）  ")
	private String msgType;
	
	
	/**
     *   发布状态（0未发布，1已发布，2已撤销）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发布状态（0未发布，1已发布，2已撤销） 不能为空") */ 
    @ApiModelProperty(value="发布状态（0未发布，1已发布，2已撤销）  ")
	private String sendStatus;
	
	
	/**
     *   发布时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发布时间 不能为空") */ 
    @ApiModelProperty(value="发布时间  ")
	private Date sendTime;
	
	
	/**
     *   撤销时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "撤销时间 不能为空") */ 
    @ApiModelProperty(value="撤销时间  ")
	private Date cancelTime;
	
	
	/**
     *   删除状态（0，正常，1已删除）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态（0，正常，1已删除） 不能为空") */ 
    @ApiModelProperty(value="删除状态（0，正常，1已删除）  ")
	private String delFlag;
	
	
	/**
     *   业务类型(email:邮件 bpm:流程)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "业务类型(email:邮件 bpm:流程) 不能为空") */ 
    @ApiModelProperty(value="业务类型(email:邮件 bpm:流程)  ")
	private String busType;
	
	
	/**
     *   业务id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "业务id 不能为空") */ 
    @ApiModelProperty(value="业务id  ")
	private String busId;
	
	
	/**
     *   打开方式(组件：component 路由：url)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "打开方式(组件：component 路由：url) 不能为空") */ 
    @ApiModelProperty(value="打开方式(组件：component 路由：url)  ")
	private String openType;
	
	
	/**
     *   组件/路由 地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "组件/路由 地址 不能为空") */ 
    @ApiModelProperty(value="组件/路由 地址  ")
	private String openPage;
	
	
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
	
	
	/**
     *   指定用户
     */
	/** @NotNull(groups = {AddGroup.class }, message = "指定用户 不能为空") */ 
    @ApiModelProperty(value="指定用户  ")
	private String userIds;
	
	
	/**
     *   摘要
     */
	/** @NotNull(groups = {AddGroup.class }, message = "摘要 不能为空") */ 
    @ApiModelProperty(value="摘要  ")
	private String msgAbstract;
	
	
	/**
     *   钉钉task_id，用于撤回消息
     */
	/** @NotNull(groups = {AddGroup.class }, message = "钉钉task_id，用于撤回消息 不能为空") */ 
    @ApiModelProperty(value="钉钉task_id，用于撤回消息  ")
	private String dtTaskId;
	
	
	/**
     *   租户ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户ID 不能为空") */ 
    @ApiModelProperty(value="租户ID  ")
	private Integer tenantId;
	
	


	
}