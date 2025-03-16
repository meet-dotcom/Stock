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
 * 角色表
 * @TableName sys_role
 */
@ApiModel(value = "SysRole", description = "角色表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SysRole implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    private String id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true)
    private String description;

    /**
     * 状态(1:正常0:弃用)
     */
    @ApiModelProperty(value = "状态(1:正常0:弃用)", required = true)
    private Integer status;

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

    /**
     * 是否删除(1未删除；0已删除)
     */
    @ApiModelProperty(value = "是否删除(1未删除；0已删除)", required = true)
    private Integer deleted;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}