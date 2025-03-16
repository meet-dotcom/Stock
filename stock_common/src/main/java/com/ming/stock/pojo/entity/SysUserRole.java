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
 * 用户角色表
 * @TableName sys_user_role
 */
@ApiModel(value = "SysUserRole", description = "用户角色表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SysUserRole implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", required = true)
    private Long roleId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}