package com.ming.stock.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 个股详情信息表
 * @TableName stock_rt_info
 */
@ApiModel(value = "StockRtInfo", description = "个股详情信息表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockRtInfo implements Serializable {
    /**
     * 主键字段（无业务意义）
     */
    @ApiModelProperty(value = "主键字段（无业务意义）", required = true)
    private Long id;

    /**
     * 股票代码
     */
    @ApiModelProperty(value = "股票代码", required = true)
    private String stockCode;

    /**
     * 股票名称
     */
    @ApiModelProperty(value = "股票名称", required = true)
    private String stockName;

    /**
     * 前收盘价| 昨日收盘价
     */
    @ApiModelProperty(value = "前收盘价|昨日收盘价", required = true)
    private BigDecimal preClosePrice;

    /**
     * 开盘价
     */
    @ApiModelProperty(value = "开盘价", required = true)
    private BigDecimal openPrice;

    /**
     * 当前价格
     */
    @ApiModelProperty(value = "当前价格", required = true)
    private BigDecimal curPrice;

    /**
     * 今日最低价
     */
    @ApiModelProperty(value = "今日最低价", required = true)
    private BigDecimal minPrice;

    /**
     * 今日最高价
     */
    @ApiModelProperty(value = "今日最高价", required = true)
    private BigDecimal maxPrice;

    /**
     * 成交量
     */
    @ApiModelProperty(value = "成交量", required = true)
    private Long tradeAmount;

    /**
     * 成交金额
     */
    @ApiModelProperty(value = "成交金额", required = true)
    private BigDecimal tradeVolume;

    /**
     * 当前时间
     */
    @ApiModelProperty(value = "当前时间", required = true)
    private Date curTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}