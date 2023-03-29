package com.laison.softwareproject.model.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laison.softwareproject.common.constants.ContentConstant;
import com.laison.softwareproject.common.utils.MyIDGenId;
import com.laison.softwareproject.common.validatgroup.AddGroup;
import com.laison.softwareproject.common.validatgroup.FindGroup;
import com.laison.softwareproject.common.validatgroup.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * @Description: 知识库-文档管理
 * @Author: jeecg-boot
 * @Date:   2022-07-21
 * @Version: V1.0
 */
@Data
@Table(name ="sys_files")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_files对象", description="知识库-文档管理")
public class SysFiles {
    
	/**主键id*/
	@Id
	@KeySql(genId = MyIDGenId.class)
	@Null(groups = {AddGroup.class }, message = ContentConstant.ID_NOT_NULL)
	@NotNull(groups = {UpdateGroup.class, FindGroup.class }, message = ContentConstant.ID_NULL)
	@ApiModelProperty(value="  ")
	private String id;
	/**文件名称*/
	
    @ApiModelProperty(value = "文件名称")
	private String fileName;
	/**文件地址*/
	
    @ApiModelProperty(value = "文件地址")
	private String url;
	/**创建人登录名称*/
	
    @ApiModelProperty(value = "创建人登录名称")
	private String createBy;
	/**创建日期*/
	
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
	private Date createTime;
	/**更新人登录名称*/
	
    @ApiModelProperty(value = "更新人登录名称")
	private String updateBy;
	/**更新日期*/
	
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
	private Date updateTime;
	/**文档类型（folder:文件夹 excel:excel doc:word pp:ppt image:图片  archive:其他文档 video:视频）*/
	
    @ApiModelProperty(value = "文档类型（folder:文件夹 excel:excel doc:word pp:ppt image:图片  archive:其他文档 video:视频）")
	private String fileType;
	/**文件上传类型(temp/本地上传(临时文件) manage/知识库)*/
	
    @ApiModelProperty(value = "文件上传类型(temp/本地上传(临时文件) manage/知识库)")
	private String storeType;
	/**父级id*/
	
    @ApiModelProperty(value = "父级id")
	private String parentId;
	/**租户id*/
	
    @ApiModelProperty(value = "租户id")
	private String tenantId;
	/**文件大小（kb）*/
	
    @ApiModelProperty(value = "文件大小（kb）")
	private Double fileSize;
	/**是否文件夹(1：是  0：否)*/
	
    @ApiModelProperty(value = "是否文件夹(1：是  0：否)")
	private String izFolder;
	/**是否为1级文件夹，允许为空 (1：是 )*/
	
    @ApiModelProperty(value = "是否为1级文件夹，允许为空 (1：是 )")
	private String izRootFolder;
	/**是否标星(1：是  0：否)*/
	
    @ApiModelProperty(value = "是否标星(1：是  0：否)")
	private String izStar;
	/**下载次数*/
	
    @ApiModelProperty(value = "下载次数")
	private Integer downCount;
	/**阅读次数*/
	
    @ApiModelProperty(value = "阅读次数")
	private Integer readCount;
	/**分享链接*/
	
    @ApiModelProperty(value = "分享链接")
	private String shareUrl;
	/**分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)*/
	
    @ApiModelProperty(value = "分享权限(1.关闭分享 2.允许所有联系人查看 3.允许任何人查看)")
	private String sharePerms;
	/**是否允许下载(1：是  0：否)*/
	
    @ApiModelProperty(value = "是否允许下载(1：是  0：否)")
	private String enableDown;
	/**是否允许修改(1：是  0：否)*/
	
    @ApiModelProperty(value = "是否允许修改(1：是  0：否)")
	private String enableUpdat;
	/**删除状态(0-正常,1-删除至回收站)*/
	
    @ApiModelProperty(value = "删除状态(0-正常,1-删除至回收站)")
	private String delFlag;

    /**
     * 文件表不存在的字段：用户数据集合
     */
    private String userData;

    /**
     * 文件表不存在的字段：用户真实姓名
     */
    private String realname;

    /**
     * 文件表不存在的字段：压缩名称
     */
    private String zipName;
}
