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
 * @date  2023-03-29 14:10:15
 * 从 sys_fill_rule 表 自动生成的entity.
 */
@Table(name="sys_fill_rule")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysFillRule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   主键ID
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="主键ID  ")
	private String id;
	
	
	/**
     *   规则名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "规则名称 不能为空") */ 
    @ApiModelProperty(value="规则名称  ")
	private String ruleName;
	
	
	/**
     *   规则Code
     */
	/** @NotNull(groups = {AddGroup.class }, message = "规则Code 不能为空") */ 
    @ApiModelProperty(value="规则Code  ")
	private String ruleCode;
	
	
	/**
     *   规则实现类
     */
	/** @NotNull(groups = {AddGroup.class }, message = "规则实现类 不能为空") */ 
    @ApiModelProperty(value="规则实现类  ")
	private String ruleClass;
	
	
	/**
     *   规则参数
     */
	/** @NotNull(groups = {AddGroup.class }, message = "规则参数 不能为空") */ 
    @ApiModelProperty(value="规则参数  ")
	private String ruleParams;
	
	
	/**
     *   修改人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "修改人 不能为空") */ 
    @ApiModelProperty(value="修改人  ")
	private String updateBy;
	
	
	/**
     *   修改时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "修改时间 不能为空") */ 
    @ApiModelProperty(value="修改时间  ")
	private Date updateTime;
	
	
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
	
	


	
}