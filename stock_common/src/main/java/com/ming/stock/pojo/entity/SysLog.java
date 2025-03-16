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
 * 系统日志
 * @TableName sys_log
 */
@ApiModel(value = "SysLog", description = "系统日志")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SysLog implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id", required = true)
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 用户操作：DELETE ADD GET UPDATE
     */
    @ApiModelProperty(value = "用户操作：DELETEADDGETUPDATE", required = true)
    private String operation;

    /**
     * 响应时间,单位毫秒
     */
    @ApiModelProperty(value = "响应时间,单位毫秒", required = true)
    private Integer time;

    /**
     * 请求方法（控制层方法全限定名）
     */
    @ApiModelProperty(value = "请求方法（控制层方法全限定名）", required = true)
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数", required = true)
    private String params;

    /**
     * IP地址
     */
    @ApiModelProperty(value = "IP地址", required = true)
    private String ip;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}