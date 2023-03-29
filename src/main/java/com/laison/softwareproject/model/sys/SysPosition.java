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
 * @date  2023-03-27 16:41:20
 * 从 sys_position 表 自动生成的entity.
 */
@Table(name="sys_position")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysPosition implements Serializable {
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
     *   职务编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "职务编码 不能为空") */ 
    @ApiModelProperty(value="职务编码  ")
	private String code;
	
	
	/**
     *   职务名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "职务名称 不能为空") */ 
    @ApiModelProperty(value="职务名称  ")
	private String name;
	
	
	/**
     *   职级
     */
	/** @NotNull(groups = {AddGroup.class }, message = "职级 不能为空") */ 
    @ApiModelProperty(value="职级  ")
	private String postRank;
	
	
	/**
     *   公司id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "公司id 不能为空") */ 
    @ApiModelProperty(value="公司id  ")
	private String companyId;
	
	
	/**
     *   组织机构编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "组织机构编码 不能为空") */ 
    @ApiModelProperty(value="组织机构编码  ")
	private String sysOrgCode;
	
	
	/**
     *   租户ID
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户ID 不能为空") */ 
    @ApiModelProperty(value="租户ID  ")
	private Integer tenantId;
	
	
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
	
	


	
}