package com.ming.stock.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

/**
 * 国内大盘数据详情表
 * @TableName stock_market_index_info
 */
@ApiModel(value = "StockMarketIndexInfo", description = "国内大盘数据详情表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockMarketIndexInfo implements Serializable {
    /**
     * 主键字段（无业务意义）
     */
    @ApiModelProperty(value = "主键字段（无业务意义）", required = true)
    private Long id;

    /**
     * 大盘编码
     */
    @ApiModelProperty(value = "大盘编码", required = true)
    private String marketCode;

    /**
     * 指数名称
     */
    @ApiModelProperty(value = "指数名称", required = true)
    private String marketName;

    /**
     * 前收盘点数
     */
    @ApiModelProperty(value = "前收盘点数", required = true)
    private BigDecimal preClosePoint;

    /**
     * 开盘点数
     */
    @ApiModelProperty(value = "开盘点数", required = true)
    private BigDecimal openPoint;

    /**
     * 当前点数
     */
    @ApiModelProperty(value = "当前点数", required = true)
    private BigDecimal curPoint;

    /**
     * 最低点数
     */
    @ApiModelProperty(value = "最低点数", required = true)
    private BigDecimal minPoint;

    /**
     * 最高点数
     */
    @ApiModelProperty(value = "最高点数", required = true)
    private BigDecimal maxPoint;

    /**
     * 成交量(手)
     */
    @ApiModelProperty(value = "成交量(手)", required = true)
    private Long tradeAmount;

    /**
     * 成交金额（元）
     */
    @ApiModelProperty(value = "成交金额（元）", required = true)
    private BigDecimal tradeVolume;

    /**
     * 当前时间
     */
    @ApiModelProperty(value = "当前时间", required = true)
    private Date curTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;



}