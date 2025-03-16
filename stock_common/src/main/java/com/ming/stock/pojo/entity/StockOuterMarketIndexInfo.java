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
 * 外盘详情信息表
 * @TableName stock_outer_market_index_info
 */
@ApiModel(value = "StockOuterMarketIndexInfo", description = "外盘详情信息表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockOuterMarketIndexInfo implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID", required = true)
    private Long id;

    /**
     * 大盘编码
     */
    @ApiModelProperty(value = "大盘编码", required = true)
    private String marketCode;

    /**
     * 大盘名称
     */
    @ApiModelProperty(value = "大盘名称", required = true)
    private String marketName;

    /**
     * 大盘当前点
     */
    @ApiModelProperty(value = "大盘当前点", required = true)
    private BigDecimal curPoint;

    /**
     * 大盘涨跌值
     */
    @ApiModelProperty(value = "大盘涨跌值", required = true)
    private BigDecimal updown;

    /**
     * 大盘涨幅
     */
    @ApiModelProperty(value = "大盘涨幅", required = true)
    private BigDecimal rose;

    /**
     * 当前时间
     */
    @ApiModelProperty(value = "当前时间", required = true)
    private Date curTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}