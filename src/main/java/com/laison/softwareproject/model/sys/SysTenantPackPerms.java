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
 * @date  2023-03-27 16:42:40
 * 从 sys_tenant_pack_perms 表 自动生成的entity.
 */
@Table(name="sys_tenant_pack_perms")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysTenantPackPerms implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     *   主键编号
     */
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class,FindGroup.class }, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value="主键编号  ")
	private String id;
	
	
	/**
     *   租户产品包名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "租户产品包名称 不能为空") */ 
    @ApiModelProperty(value="租户产品包名称  ")
	private String packId;
	
	
	/**
     *   菜单id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "菜单id 不能为空") */ 
    @ApiModelProperty(value="菜单id  ")
	private String permissionId;
	
	
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
	private String createTime;
	
	
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
	private String updateTime;
	
	


	
}