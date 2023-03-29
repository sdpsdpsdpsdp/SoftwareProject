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
 * @date  2023-03-27 16:43:07
 * 从 sys_third_account 表 自动生成的entity.
 */
@Table(name="sys_third_account")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysThirdAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   编号
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="编号  ")
	private String id;
	
	
	/**
     *   第三方登录id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "第三方登录id 不能为空") */ 
    @ApiModelProperty(value="第三方登录id  ")
	private String sysUserId;
	
	
	/**
     *   头像
     */
	/** @NotNull(groups = {AddGroup.class }, message = "头像 不能为空") */ 
    @ApiModelProperty(value="头像  ")
	private String avatar;
	
	
	/**
     *   状态(1-正常,2-冻结)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态(1-正常,2-冻结) 不能为空") */ 
    @ApiModelProperty(value="状态(1-正常,2-冻结)  ")
	private Boolean status;
	
	
	/**
     *   删除状态(0-正常,1-已删除)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态(0-正常,1-已删除) 不能为空") */ 
    @ApiModelProperty(value="删除状态(0-正常,1-已删除)  ")
	private Boolean delFlag;
	
	
	/**
     *   真实姓名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "真实姓名 不能为空") */ 
    @ApiModelProperty(value="真实姓名  ")
	private String realname;
	
	
	/**
     *   第三方账号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "第三方账号 不能为空") */ 
    @ApiModelProperty(value="第三方账号  ")
	private String thirdUserUuid;
	
	
	/**
     *   第三方app用户账号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "第三方app用户账号 不能为空") */ 
    @ApiModelProperty(value="第三方app用户账号  ")
	private String thirdUserId;
	
	
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
	
	
	/**
     *   登录来源
     */
	/** @NotNull(groups = {AddGroup.class }, message = "登录来源 不能为空") */ 
    @ApiModelProperty(value="登录来源  ")
	private String thirdType;
	
	


	
}