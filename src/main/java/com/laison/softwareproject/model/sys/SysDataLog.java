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
 * @date  2023-03-29 14:09:18
 * 从 sys_data_log 表 自动生成的entity.
 */
@Table(name="sys_data_log")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysDataLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   id
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="id  ")
	private String id;
	
	
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
     *   表名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "表名 不能为空") */ 
    @ApiModelProperty(value="表名  ")
	private String dataTable;
	
	
	/**
     *   数据ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据ID 不能为空") */ 
    @ApiModelProperty(value="数据ID  ")
	private String dataId;
	
	
	/**
     *   数据内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据内容 不能为空") */ 
    @ApiModelProperty(value="数据内容  ")
	private String dataContent;
	
	
	/**
     *   版本号
     */
	/** @NotNull(groups = {AddGroup.class }, message = "版本号 不能为空") */ 
    @ApiModelProperty(value="版本号  ")
	private Integer dataVersion;
	
	
	/**
     *   类型
     */
	/** @NotNull(groups = {AddGroup.class }, message = "类型 不能为空") */ 
    @ApiModelProperty(value="类型  ")
	private String type;
	
	


	
}