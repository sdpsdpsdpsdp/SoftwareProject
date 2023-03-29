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
 * @date  2023-03-27 16:40:14
 * 从 sys_dict 表 自动生成的entity.
 */
@Table(name="sys_dict")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysDict implements Serializable {
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
     *   字典名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典名称 不能为空") */ 
    @ApiModelProperty(value="字典名称  ")
	private String dictName;
	
	
	/**
     *   字典编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典编码 不能为空") */ 
    @ApiModelProperty(value="字典编码  ")
	private String dictCode;
	
	
	/**
     *   描述
     */
	/** @NotNull(groups = {AddGroup.class }, message = "描述 不能为空") */ 
    @ApiModelProperty(value="描述  ")
	private String description;
	
	
	/**
     *   删除状态
     */
	/** @NotNull(groups = {AddGroup.class }, message = "删除状态 不能为空") */ 
    @ApiModelProperty(value="删除状态  ")
	private Integer delFlag;
	
	
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
     *   字典类型0为string,1为number
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典类型0为string,1为number 不能为空") */ 
    @ApiModelProperty(value="字典类型0为string,1为number  ")
	private Integer type;
	
	
	/**
     *   租户ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户ID 不能为空") */ 
    @ApiModelProperty(value="租户ID  ")
	private Integer tenantId;
	
	
	/**
     *   低代码应用ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "低代码应用ID 不能为空") */ 
    @ApiModelProperty(value="低代码应用ID  ")
	private String lowAppId;
	
	


	
}