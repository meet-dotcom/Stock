package com.ming.stock.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户表
 * @TableName sys_user
 */
@ApiModel(value = "SysUser", description = "用户表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    private String id;

    /**
     * 账户
     */
    @ApiModelProperty(value = "账户", required = true)
    private String username;

    /**
     * 用户密码密文
     */
    @ApiModelProperty(value = "用户密码密文", required = true)
    private String password;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;

    /**
     * 真实名称
     */
    @ApiModelProperty(value = "真实名称", required = true)
    private String realName;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", required = true)
    private String nickName;

    /**
     * 邮箱(唯一)
     */
    @ApiModelProperty(value = "邮箱(唯一)", required = true)
    private String email;

    /**
     * 账户状态(1.正常 2.锁定 )
     */
    @ApiModelProperty(value = "账户状态(1.正常2.锁定)", required = true)
    private Integer status;

    /**
     * 性别(1.男 2.女)
     */
    @ApiModelProperty(value = "性别(1.男2.女)", required = true)
    private Integer sex;

    /**
     * 是否删除(1未删除；0已删除)
     */
    @ApiModelProperty(value = "是否删除(1未删除；0已删除)", required = true)
    private Integer deleted;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", required = true)
    private Long createId;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人", required = true)
    private Long updateId;

    /**
     * 创建来源(1.web 2.android 3.ios )
     */
    @ApiModelProperty(value = "创建来源(1.web2.android3.ios)", required = true)
    private Integer createWhere;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}