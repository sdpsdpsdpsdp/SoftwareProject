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
 * @date  2023-03-29 14:06:43
 * 从 sys_announcement_send 表 自动生成的entity.
 */
@Table(name="sys_announcement_send")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysAnnouncementSend implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   
     */
	/** @NotNull(groups = {AddGroup.class }, message = " 不能为空") */ 
    @ApiModelProperty(value="  ")
	private String id;
	
	
	/**
     *   通告ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "通告ID 不能为空") */ 
    @ApiModelProperty(value="通告ID  ")
	private String anntId;
	
	
	/**
     *   用户id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "用户id 不能为空") */ 
    @ApiModelProperty(value="用户id  ")
	private String userId;
	
	
	/**
     *   阅读状态（0未读，1已读）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "阅读状态（0未读，1已读） 不能为空") */ 
    @ApiModelProperty(value="阅读状态（0未读，1已读）  ")
	private String readFlag;
	
	
	/**
     *   阅读时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "阅读时间 不能为空") */ 
    @ApiModelProperty(value="阅读时间  ")
	private Date readTime;
	
	
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
     *   标星状态( 1为标星 空/0没有标星)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "标星状态( 1为标星 空/0没有标星) 不能为空") */ 
    @ApiModelProperty(value="标星状态( 1为标星 空/0没有标星)  ")
	private String starFlag;
	
	


	
}