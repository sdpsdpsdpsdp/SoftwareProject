package com.laison.softwareproject.model.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
 * @date  2023-03-27 16:23:23
 * 从 sys_category 表 自动生成的entity.
 */
@Table(name="sys_category")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysCategory implements Serializable {
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
     *   父级节点
     */
	/** @NotNull(groups = {AddGroup.class }, message = "父级节点 不能为空") */ 
    @ApiModelProperty(value="父级节点  ")
	private String pid;
	
	
	/**
     *   类型名称
     */
	/** @NotNull(groups = {AddGroup.class }, message = "类型名称 不能为空") */ 
    @ApiModelProperty(value="类型名称  ")
	private String name;
	
	
	/**
     *   类型编码
     */
	/** @NotNull(groups = {AddGroup.class }, message = "类型编码 不能为空") */ 
    @ApiModelProperty(value="类型编码  ")
	private String code;
	
	
	/**
     *   是否有子节点
     */
	/** @NotNull(groups = {AddGroup.class }, message = "是否有子节点 不能为空") */ 
    @ApiModelProperty(value="是否有子节点  ")
	private String hasChild;
	
	@Transient
    private List<SysCategory> children;
    /** children 发给前端的时候不能为null 要发一个空数组 */ 
//    public List<SysCategory> getChildren() {
//    	if(this.hasChild !=null && this.hasChild &&this.children ==null) {
//    		this.children=new ArrayList<>();
//    	}
//		return this.children;
//	};
	
	
	/**
     *   所属部门
     */
	/** @NotNull(groups = {AddGroup.class }, message = "所属部门 不能为空") */ 
    @ApiModelProperty(value="所属部门  ")
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
     *   创建日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "创建日期 不能为空") */ 
    @ApiModelProperty(value="创建日期  ")
	private Date createTime;
	
	
	/**
     *   更新人
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新人 不能为空") */ 
    @ApiModelProperty(value="更新人  ")
	private String updateBy;
	
	
	/**
     *   更新日期
     */
	/** @NotNull(groups = {AddGroup.class }, message = "更新日期 不能为空") */ 
    @ApiModelProperty(value="更新日期  ")
	private Date updateTime;
	
	


	
}