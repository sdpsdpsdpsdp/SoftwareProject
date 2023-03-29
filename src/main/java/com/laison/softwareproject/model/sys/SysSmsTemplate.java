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
 * @date  2023-03-29 14:11:22
 * 从 sys_sms_template 表 自动生成的entity.
 */
@Table(name="sys_sms_template")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysSmsTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   主键
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="主键  ")
	private String id;
	
	
	/**
     *   模板标题
     */
	/** @NotNull(groups = {AddGroup.class }, message = "模板标题 不能为空") */ 
    @ApiModelProperty(value="模板标题  ")
	private String templateName;
	
	
	/**
     *   模板CODE
     */
	/** @NotNull(groups = {AddGroup.class }, message = "模板CODE 不能为空") */ 
    @ApiModelProperty(value="模板CODE  ")
	private String templateCode;
	
	
	/**
     *   模板类型：1短信 2邮件 3微信
     */
	/** @NotNull(groups = {AddGroup.class }, message = "模板类型：1短信 2邮件 3微信 不能为空") */ 
    @ApiModelProperty(value="模板类型：1短信 2邮件 3微信  ")
	private String templateType;
	
	
	/**
     *   模板内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "模板内容 不能为空") */ 
    @ApiModelProperty(value="模板内容  ")
	private String templateContent;
	
	
	/**
     *   模板测试json
     */
	/** @NotNull(groups = {AddGroup.class }, message = "模板测试json 不能为空") */ 
    @ApiModelProperty(value="模板测试json  ")
	private String templateTestJson;
	
	
	/**
     *   创建日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建日期 不能为空") */ 
    @ApiModelProperty(value="创建日期  ")
	private Date createTime;
	
	
	/**
     *   创建人登录名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建人登录名称 不能为空") */ 
    @ApiModelProperty(value="创建人登录名称  ")
	private String createBy;
	
	
	/**
     *   更新日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新日期 不能为空") */ 
    @ApiModelProperty(value="更新日期  ")
	private Date updateTime;
	
	
	/**
     *   更新人登录名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人登录名称 不能为空") */ 
    @ApiModelProperty(value="更新人登录名称  ")
	private String updateBy;
	
	
	/**
     *   是否使用中 1是0否
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否使用中 1是0否 不能为空") */ 
    @ApiModelProperty(value="是否使用中 1是0否  ")
	private String useStatus;
	
	


	
}