package com.laison.softwareproject.model.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Collection;
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
 * @date 2023-03-27 16:43:20
 * 从 sys_user 表 自动生成的entity.
 */
@Table(name = "sys_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @KeySql(genId = MyIDGenId.class)
    @Null(groups = {AddGroup.class}, message = ContentConstant.ID_NOT_NULL)
    @NotNull(groups = {UpdateGroup.class, FindGroup.class}, message = ContentConstant.ID_NULL)
    @ApiModelProperty(value = "主键  ")
    private String id;


    /**
     *   登录名
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "登录名 不能为空")
     */
    @ApiModelProperty(value = "登录名  ")
    private String username;


    /**
     *   真实姓名
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "真实姓名 不能为空")
     */
    @ApiModelProperty(value = "真实姓名  ")
    private String realname;


    /**
     *   别名
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "别名 不能为空")
     */
    @ApiModelProperty(value = "别名  ")
    private String nickname;


    /**
     *   密码
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "密码 不能为空")
     */
    @ApiModelProperty(value = "密码  ")
    private String password;


    /**
     *   md5密码盐
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "md5密码盐 不能为空")
     */
    @ApiModelProperty(value = "md5密码盐  ")
    private String salt;


    /**
     *   头像
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "头像 不能为空")
     */
    @ApiModelProperty(value = "头像  ")
    private String avatar;


    /**
     *   生日
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "生日 不能为空")
     */
    @ApiModelProperty(value = "生日  ")
    private Date birthday;


    /**
     *   性别 0-未知 1-男 2-女
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "性别 0-未知 1-男 2-女 不能为空")
     */
    @ApiModelProperty(value = "性别 0-未知 1-男 2-女  ")
    private Integer gender;


    /**
     *   邮箱
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "邮箱 不能为空")
     */
    @ApiModelProperty(value = "邮箱  ")
    private String email;


    /**
     *   电话
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "电话 不能为空")
     */
    @ApiModelProperty(value = "电话  ")
    private String phone;


    /**
     *   座机号
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "座机号 不能为空")
     */
    @ApiModelProperty(value = "座机号  ")
    private String telephone;


    /**
     *   登录会话的机构编码
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "登录会话的机构编码 不能为空")
     */
    @ApiModelProperty(value = "登录会话的机构编码  ")
    private String orgCode;


    /**
     *   第三方登录的唯一标识
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "第三方登录的唯一标识 不能为空")
     */
    @ApiModelProperty(value = "第三方登录的唯一标识  ")
    private String thirdId;


    /**
     *   第三方类型
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "第三方类型 不能为空")
     */
    @ApiModelProperty(value = "第三方类型  ")
    private String thirdType;


    /**
     *   1-同步，0-不同步
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "1-同步，0-不同步 不能为空")
     */
    @ApiModelProperty(value = "1-同步，0-不同步  ")
    private Boolean activitiSync;


    /**
     *   工号
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "工号 不能为空")
     */
    @ApiModelProperty(value = "工号  ")
    private String wrokNo;


    /**
     *   职务（关联职务表）
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "职务（关联职务表） 不能为空")
     */
    @ApiModelProperty(value = "职务（关联职务表）  ")
    private String post;


    /**
     *   身份（1-普通 2-上级）
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "身份（1-普通 2-上级） 不能为空")
     */
    @ApiModelProperty(value = "身份（1-普通 2-上级）  ")
    private Integer userIdentity;


    /**
     *   负责部门
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "负责部门 不能为空")
     */
    @ApiModelProperty(value = "负责部门  ")
    private String departIds;


    /**
     *   设备id
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "设备id 不能为空")
     */
    @ApiModelProperty(value = "设备id  ")
    private String clientId;


    /**
     *   流程入职离职状态
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "流程入职离职状态 不能为空")
     */
    @ApiModelProperty(value = "流程入职离职状态  ")
    private String bpmStatus;


    /**
     *   专业
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "专业 不能为空")
     */
    @ApiModelProperty(value = "专业  ")
    private String subject;


    /**
     *   上次登录选择的租户id
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "上次登录选择的租户id 不能为空")
     */
    @ApiModelProperty(value = "上次登录选择的租户id  ")
    private Integer loginTenantId;


    /**
     *   状态（1-正常，2-冻结）
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "状态（1-正常，2-冻结） 不能为空")
     */
    @ApiModelProperty(value = "状态（1-正常，2-冻结）  ")
    private Integer status;


    /**
     *   删除状态（0-正常，1-已删除）
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "删除状态（0-正常，1-已删除） 不能为空")
     */
    @ApiModelProperty(value = "删除状态（0-正常，1-已删除）  ")
    private Boolean delFlag;


    /**
     *   创建人
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "创建人 不能为空")
     */
    @ApiModelProperty(value = "创建人  ")
    private String createBy;


    /**
     *   创建时间
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "创建时间 不能为空")
     */
    @ApiModelProperty(value = "创建时间  ")
    private Date createTime;


    /**
     *   更新人
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "更新人 不能为空")
     */
    @ApiModelProperty(value = "更新人  ")
    private String updateBy;


    /**
     *   更新时间
     */
    /**
     * @NotNull(groups = {AddGroup.class }, message = "更新时间 不能为空")
     */
    @ApiModelProperty(value = "更新时间  ")
    private Date updateTime;
    /**
     * 多租户ids临时用，不持久化数据库(数据库字段不存在)
     */
    @Transient
    private String relTenantIds;


    public SysRole getSysRole() {
        return null;
    }

    public Collection<String> getPermissions() {
        return null;
    }
}