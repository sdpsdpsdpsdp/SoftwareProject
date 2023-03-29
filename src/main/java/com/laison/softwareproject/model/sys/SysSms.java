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
 * @date  2023-03-29 14:11:08
 * 从 sys_sms 表 自动生成的entity.
 */
@Table(name="sys_sms")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysSms implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   ID
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="ID  ")
	private String id;
	
	
	/**
     *   消息标题
     */
	/** @NotNull(groups = {AddGroup.class }, message = "消息标题 不能为空") */ 
    @ApiModelProperty(value="消息标题  ")
	private String esTitle;
	
	
	/**
     *   发送方式：参考枚举MessageTypeEnum
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发送方式：参考枚举MessageTypeEnum 不能为空") */ 
    @ApiModelProperty(value="发送方式：参考枚举MessageTypeEnum  ")
	private String esType;
	
	
	/**
     *   接收人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "接收人 不能为空") */ 
    @ApiModelProperty(value="接收人  ")
	private String esReceiver;
	
	
	/**
     *   发送所需参数Json格式
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发送所需参数Json格式 不能为空") */ 
    @ApiModelProperty(value="发送所需参数Json格式  ")
	private String esParam;
	
	
	/**
     *   推送内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "推送内容 不能为空") */ 
    @ApiModelProperty(value="推送内容  ")
	private String esContent;
	
	
	/**
     *   推送时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "推送时间 不能为空") */ 
    @ApiModelProperty(value="推送时间  ")
	private Date esSendTime;
	
	
	/**
     *   推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送
     */
	/** @NotNull(groups = {AddGroup.class }, message = "推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送 不能为空") */ 
    @ApiModelProperty(value="推送状态 0未推送 1推送成功 2推送失败 -1失败不再发送  ")
	private String esSendStatus;
	
	
	/**
     *   发送次数 超过5次不再发送
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发送次数 超过5次不再发送 不能为空") */ 
    @ApiModelProperty(value="发送次数 超过5次不再发送  ")
	private Integer esSendNum;
	
	
	/**
     *   推送失败原因
     */
	/** @NotNull(groups = {AddGroup.class }, message = "推送失败原因 不能为空") */ 
    @ApiModelProperty(value="推送失败原因  ")
	private String esResult;
	
	
	/**
     *   备注
     */
	/** @NotNull(groups = {AddGroup.class }, message = "备注 不能为空") */ 
    @ApiModelProperty(value="备注  ")
	private String remark;
	
	
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