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
 * @date  2023-03-29 14:10:28
 * 从 sys_form_file 表 自动生成的entity.
 */
@Table(name="sys_form_file")
@JsonInclude(JsonInclude.Include.NON_NULL) 
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysFormFile implements Serializable {
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
     *   关联文件id
     */
	/** @NotNull(groups = {AddGroup.class }, message = "关联文件id 不能为空") */ 
    @ApiModelProperty(value="关联文件id  ")
	private String fileId;
	
	
	/**
     *   文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)
     */
	/** @NotNull(groups = {AddGroup.class }, message = "文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）) 不能为空") */ 
    @ApiModelProperty(value="文件类型(text:文本, excel:excel doc:word ppt:ppt image:图片  archive:其他文档 video:视频 pdf:pdf）)  ")
	private String fileType;
	
	
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
	
	


	
}