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
 * @date  2023-03-27 16:43:33
 * 从 sys_user_agent 表 自动生成的entity.
 */
@Table(name="sys_user_agent")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysUserAgent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   序号
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="序号  ")
	private String id;
	
	
	/**
     *   用户名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "用户名 不能为空") */ 
    @ApiModelProperty(value="用户名  ")
	private String userName;
	
	
	/**
     *   代理人用户名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "代理人用户名 不能为空") */ 
    @ApiModelProperty(value="代理人用户名  ")
	private String agentUserName;
	
	
	/**
     *   代理开始时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "代理开始时间 不能为空") */ 
    @ApiModelProperty(value="代理开始时间  ")
	private Date startTime;
	
	
	/**
     *   代理结束时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "代理结束时间 不能为空") */ 
    @ApiModelProperty(value="代理结束时间  ")
	private Date endTime;
	
	
	/**
     *   所属部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属部门 不能为空") */ 
    @ApiModelProperty(value="所属部门  ")
	private String sysOrgCode;
	
	
	/**
     *   所属公司
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属公司 不能为空") */ 
    @ApiModelProperty(value="所属公司  ")
	private String sysCompanyCode;
	
	
	/**
     *   创建人名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建人名称 不能为空") */ 
    @ApiModelProperty(value="创建人名称  ")
	private String createName;
	
	
	/**
     *   更新人名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人名称 不能为空") */ 
    @ApiModelProperty(value="更新人名称  ")
	private String updateName;
	
	
	/**
     *   状态0无效1有效
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态0无效1有效 不能为空") */ 
    @ApiModelProperty(value="状态0无效1有效  ")
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