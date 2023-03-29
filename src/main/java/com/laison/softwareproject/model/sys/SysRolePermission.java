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
 * @date  2023-03-27 16:42:02
 * 从 sys_role_permission 表 自动生成的entity.
 */
@Table(name="sys_role_permission")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysRolePermission implements Serializable {
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
     *   角色id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "角色id 不能为空") */ 
    @ApiModelProperty(value="角色id  ")
	private String roleId;
	
	
	/**
     *   权限id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "权限id 不能为空") */ 
    @ApiModelProperty(value="权限id  ")
	private String permissionId;
	
	
	/**
     *   数据权限ids
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据权限ids 不能为空") */ 
    @ApiModelProperty(value="数据权限ids  ")
	private String dataRuleIds;
	
	
	/**
     *   操作时间
     */
	/** @NotNull(groups = {AddGroup.class }, message = "操作时间 不能为空") */ 
    @ApiModelProperty(value="操作时间  ")
	private Date operateDate;
	
	
	/**
     *   操作ip
     */
	/** @NotNull(groups = {AddGroup.class }, message = "操作ip 不能为空") */ 
    @ApiModelProperty(value="操作ip  ")
	private String operateIp;
	
	


	
}