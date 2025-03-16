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
 * 股票板块详情信息表
 * @TableName stock_block_rt_info
 */
@ApiModel(value = "StockBlockRtInfo", description = "股票板块详情信息表")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StockBlockRtInfo implements Serializable {
    /**
     * 板块主键ID（业务无关）
     */
    @ApiModelProperty(value = "板块主键ID（业务无关）", required = true)
    private Long id;

    /**
     * 表示，如：new_blhy-玻璃行业
     */
    @ApiModelProperty(value = "表示，如：new_blhy-玻璃行业", required = true)
    private String label;

    /**
     * 板块名称
     */
    @ApiModelProperty(value = "板块名称", required = true)
    private String blockName;

    /**
     * 公司数量
     */
    @ApiModelProperty(value = "公司数量", required = true)
    private Integer companyNum;

    /**
     * 平均价格
     */
    @ApiModelProperty(value = "平均价格", required = true)
    private BigDecimal avgPrice;

    /**
     * 涨跌幅
     */
    @ApiModelProperty(value = "涨跌幅", required = true)
    private BigDecimal updownRate;

    /**
     * 交易量
     */
    @ApiModelProperty(value = "交易量", required = true)
    private Long tradeAmount;

    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额", required = true)
    private BigDecimal tradeVolume;

    /**
     * 当前日期（精确到秒）
     */
    @ApiModelProperty(value = "当前日期（精确到秒）", required = true)
    private Date curTime;

    @ApiModelProperty(value = "", required = true)
    private static final long serialVersionUID = 1L;
}