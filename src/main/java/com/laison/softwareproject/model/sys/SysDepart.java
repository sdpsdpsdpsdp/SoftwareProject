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
 * @date  2023-03-27 16:38:10
 * 从 sys_depart 表 自动生成的entity.
 */
@Table(name="sys_depart")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysDepart implements Serializable {
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
     *   父id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "父id 不能为空") */ 
    @ApiModelProperty(value="父id  ")
	private String parentId;
	
	
	/**
     *   部门名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "部门名称 不能为空") */ 
    @ApiModelProperty(value="部门名称  ")
	private String departName;
	
	
	/**
     *   部门名称外文
     */
	/** @NotNull(groups = {AddGroup.class }, message = "部门名称外文 不能为空") */ 
    @ApiModelProperty(value="部门名称外文  ")
	private String departNameEn;
	
	
	/**
     *   部门名称外文缩写
     */
	/** @NotNull(groups = {AddGroup.class }, message = "部门名称外文缩写 不能为空") */ 
    @ApiModelProperty(value="部门名称外文缩写  ")
	private String departNameAbbr;
	
	
	/**
     *   排序
     */
	/** @NotNull(groups = {AddGroup.class }, message = "排序 不能为空") */ 
    @ApiModelProperty(value="排序  ")
	private Integer departOrder;
	
	
	/**
     *   描述内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "描述内容 不能为空") */ 
    @ApiModelProperty(value="描述内容  ")
	private String description;
	
	
	/**
     *   机构类别 1-公司 2-组织机构 3-等
     */
	/** @NotNull(groups = {AddGroup.class }, message = "机构类别 1-公司 2-组织机构 3-等 不能为空") */ 
    @ApiModelProperty(value="机构类别 1-公司 2-组织机构 3-等  ")
	private String orgCategory;
	
	
	/**
     *   机构类型 1-一级部门 2-子部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "机构类型 1-一级部门 2-子部门 不能为空") */ 
    @ApiModelProperty(value="机构类型 1-一级部门 2-子部门  ")
	private String orgType;
	
	
	/**
     *   机构编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "机构编码 不能为空") */ 
    @ApiModelProperty(value="机构编码  ")
	private String orgCode;
	
	
	/**
     *   手机号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "手机号 不能为空") */ 
    @ApiModelProperty(value="手机号  ")
	private String mobile;
	
	
	/**
     *   传真
     */
	/** @NotNull(groups = {AddGroup.class }, message = "传真 不能为空") */ 
    @ApiModelProperty(value="传真  ")
	private String fax;
	
	
	/**
     *   地址
     */
	/** @NotNull(groups = {AddGroup.class }, message = "地址 不能为空") */ 
    @ApiModelProperty(value="地址  ")
	private String address;
	
	
	/**
     *   备注
     */
	/** @NotNull(groups = {AddGroup.class }, message = "备注 不能为空") */ 
    @ApiModelProperty(value="备注  ")
	private String memo;
	
	
	/**
     *   对接企业微信的ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "对接企业微信的ID 不能为空") */ 
    @ApiModelProperty(value="对接企业微信的ID  ")
	private String qywxIdentifier;
	
	
	/**
     *   是否有叶子节点: 1是0否
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否有叶子节点: 1是0否 不能为空") */ 
    @ApiModelProperty(value="是否有叶子节点: 1是0否  ")
	private Boolean izLeaf;
	
	
	/**
     *   租户id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户id 不能为空") */ 
    @ApiModelProperty(value="租户id  ")
	private Integer tenantId;
	
	
	/**
     *   状态（1启用，0不启用）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态（1启用，0不启用） 不能为空") */ 
    @ApiModelProperty(value="状态（1启用，0不启用）  ")
	private Boolean status;
	
	
	/**
     *   删除状态（0，正常，1已删除）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态（0，正常，1已删除） 不能为空") */ 
    @ApiModelProperty(value="删除状态（0，正常，1已删除）  ")
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