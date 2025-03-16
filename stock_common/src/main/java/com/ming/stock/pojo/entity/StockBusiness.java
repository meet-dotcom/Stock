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
 * 主营业务表
 * @TableName stock_business
 */
@ApiModel(value = "StockBusiness", description = "主营业务表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockBusiness implements Serializable {
    /**
     *  股票编码
     */
    @ApiModelProperty(value = "股票编码", required = true)
    private String stockCode;

    /**
     * 股票名称
     */
    @ApiModelProperty(value = "股票名称", required = true)
    private String stockName;

    /**
     * 股票所属行业|板块标识
     */
    @ApiModelProperty(value = "股票所属行业|板块标识", required = true)
    private String blockLabel;

    /**
     * 行业板块名称
     */
    @ApiModelProperty(value = "行业板块名称", required = true)
    private String blockName;

    /**
     * 主营业务
     */
    @ApiModelProperty(value = "主营业务", required = true)
    private String business;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = true)
    private Date updateTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}