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
 * 角色权限表
 * @TableName sys_role_permission
 */
@ApiModel(value = "SysRolePermission", description = "角色权限表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SysRolePermission implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    private String id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", required = true)
    private String roleId;

    /**
     * 菜单权限id
     */
    @ApiModelProperty(value = "菜单权限id", required = true)
    private String permissionId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}