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
 * @date  2023-03-29 14:09:01
 * 从 sys_comment 表 自动生成的entity.
 */
@Table(name="sys_comment")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysComment implements Serializable {
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
     *   表名
     */
	/** @NotNull(groups = {AddGroup.class }, message = "表名 不能为空") */ 
    @ApiModelProperty(value="表名  ")
	private String tableName;
	
	
	/**
     *   数据id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "数据id 不能为空") */ 
    @ApiModelProperty(value="数据id  ")
	private String tableDataId;
	
	
	/**
     *   来源用户id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "来源用户id 不能为空") */ 
    @ApiModelProperty(value="来源用户id  ")
	private String fromUserId;
	
	
	/**
     *   发送给用户id(允许为空)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "发送给用户id(允许为空) 不能为空") */ 
    @ApiModelProperty(value="发送给用户id(允许为空)  ")
	private String toUserId;
	
	
	/**
     *   评论id(允许为空，不为空时，则为回复)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "评论id(允许为空，不为空时，则为回复) 不能为空") */ 
    @ApiModelProperty(value="评论id(允许为空，不为空时，则为回复)  ")
	private String commentId;
	
	
	/**
     *   回复内容
     */
	/** @NotNull(groups = {AddGroup.class }, message = "回复内容 不能为空") */ 
    @ApiModelProperty(value="回复内容  ")
	private String commentContent;
	
	
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