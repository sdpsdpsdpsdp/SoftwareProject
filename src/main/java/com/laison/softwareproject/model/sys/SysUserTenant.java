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
 * @date  2023-03-27 16:44:10
 * 从 sys_user_tenant 表 自动生成的entity.
 */
@Table(name="sys_user_tenant")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysUserTenant implements Serializable {
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
     *   用户id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "用户id 不能为空") */ 
    @ApiModelProperty(value="用户id  ")
	private String userId;
	
	
	/**
     *   租户id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户id 不能为空") */ 
    @ApiModelProperty(value="租户id  ")
	private Integer tenantId;
	
	
	/**
     *   状态(1 正常 2 离职 3 待审核 4 审核未通过)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态(1 正常 2 离职 3 待审核 4 审核未通过) 不能为空") */ 
    @ApiModelProperty(value="状态(1 正常 2 离职 3 待审核 4 审核未通过)  ")
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