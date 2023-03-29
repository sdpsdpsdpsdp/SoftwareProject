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
 * @date  2023-03-27 16:40:27
 * 从 sys_dict_item 表 自动生成的entity.
 */
@Table(name="sys_dict_item")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysDictItem implements Serializable {
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
     *   字典id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典id 不能为空") */ 
    @ApiModelProperty(value="字典id  ")
	private String dictId;
	
	
	/**
     *   字典项文本
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典项文本 不能为空") */ 
    @ApiModelProperty(value="字典项文本  ")
	private String itemText;
	
	
	/**
     *   字典项值
     */
	/** @NotNull(groups = {AddGroup.class }, message = "字典项值 不能为空") */ 
    @ApiModelProperty(value="字典项值  ")
	private String itemValue;
	
	
	/**
     *   描述
     */
	/** @NotNull(groups = {AddGroup.class }, message = "描述 不能为空") */ 
    @ApiModelProperty(value="描述  ")
	private String description;
	
	
	/**
     *   排序
     */
	/** @NotNull(groups = {AddGroup.class }, message = "排序 不能为空") */ 
    @ApiModelProperty(value="排序  ")
	private Integer sortOrder;
	
	
	/**
     *   状态（1启用 0不启用）
     */
	/** @NotNull(groups = {AddGroup.class }, message = "状态（1启用 0不启用） 不能为空") */ 
    @ApiModelProperty(value="状态（1启用 0不启用）  ")
	private Integer status;
	
	
	/**
     *   
     */
	/** @NotNull(groups = {AddGroup.class }, message = " 不能为空") */ 
    @ApiModelProperty(value="  ")
	private String createBy;
	
	
	/**
     *   
     */
	/** @NotNull(groups = {AddGroup.class }, message = " 不能为空") */ 
    @ApiModelProperty(value="  ")
	private Date createTime;
	
	
	/**
     *   
     */
	/** @NotNull(groups = {AddGroup.class }, message = " 不能为空") */ 
    @ApiModelProperty(value="  ")
	private String updateBy;
	
	
	/**
     *   
     */
	/** @NotNull(groups = {AddGroup.class }, message = " 不能为空") */ 
    @ApiModelProperty(value="  ")
	private Date updateTime;
	
	


	
}