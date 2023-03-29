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
 * @date  2023-03-27 16:42:14
 * 从 sys_tenant 表 自动生成的entity.
 */
@Table(name="sys_tenant")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysTenant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   租户编码
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增主键
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="租户编码  ")
	private Integer id;
	
	
	/**
     *   租户名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户名称 不能为空") */ 
    @ApiModelProperty(value="租户名称  ")
	private String name;
	
	
	/**
     *   开始时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "开始时间 不能为空") */ 
    @ApiModelProperty(value="开始时间  ")
	private Date beginDate;
	
	
	/**
     *   结束时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "结束时间 不能为空") */ 
    @ApiModelProperty(value="结束时间  ")
	private Date endDate;
	
	
	/**
     *   所属行业
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属行业 不能为空") */ 
    @ApiModelProperty(value="所属行业  ")
	private String trade;
	
	
	/**
     *   公司规模
     */
	/** @NotNull(groups = {AddGroup.class }, message = "公司规模 不能为空") */ 
    @ApiModelProperty(value="公司规模  ")
	private String companySize;
	
	
	/**
     *   公司地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "公司地址 不能为空") */ 
    @ApiModelProperty(value="公司地址  ")
	private String companyAddress;
	
	
	/**
     *   公司logo
     */
	/** @NotNull(groups = {AddGroup.class }, message = "公司logo 不能为空") */ 
    @ApiModelProperty(value="公司logo  ")
	private String companyLogo;
	
	
	/**
     *   门牌号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "门牌号 不能为空") */ 
    @ApiModelProperty(value="门牌号  ")
	private String houseNumber;
	
	
	/**
     *   工作地点
     */
	/** @NotNull(groups = {AddGroup.class }, message = "工作地点 不能为空") */ 
    @ApiModelProperty(value="工作地点  ")
	private String workPlace;
	
	
	/**
     *   二级域名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "二级域名 不能为空") */ 
    @ApiModelProperty(value="二级域名  ")
	private String secondaryDomain;
	
	
	/**
     *   登录背景图片
     */
	/** @NotNull(groups = {AddGroup.class }, message = "登录背景图片 不能为空") */ 
    @ApiModelProperty(value="登录背景图片  ")
	private String loginBkgdImg;
	
	
	/**
     *   职级
     */
	/** @NotNull(groups = {AddGroup.class }, message = "职级 不能为空") */ 
    @ApiModelProperty(value="职级  ")
	private String position;
	
	
	/**
     *   部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "部门 不能为空") */ 
    @ApiModelProperty(value="部门  ")
	private String department;
	
	
	/**
     *   允许申请管理员 1允许 0不允许
     */
	/** @NotNull(groups = {AddGroup.class }, message = "允许申请管理员 1允许 0不允许 不能为空") */ 
    @ApiModelProperty(value="允许申请管理员 1允许 0不允许  ")
	private Integer applyStatus;
	
	
	/**
     *   状态 1正常 0冻结
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态 1正常 0冻结 不能为空") */ 
    @ApiModelProperty(value="状态 1正常 0冻结  ")
	private Boolean status;
	
	
	/**
     *   删除状态(0-正常,1-已删除)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态(0-正常,1-已删除) 不能为空") */ 
    @ApiModelProperty(value="删除状态(0-正常,1-已删除)  ")
	private Boolean delFlag;
	
	
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