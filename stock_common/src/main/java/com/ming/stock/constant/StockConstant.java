package com.ming.stock.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 常用类信息封装
 */
@ApiModel(description = "常用类信息封装")
public class StockConstant {
    /**
     * 定义校验码的前缀
     */
    @ApiModelProperty(value = "定义校验码的前缀", position = 1)
    public static final String CHECK_PREFIX = "CK";
    /**
     * http请求头携带Token信息key
     */
    @ApiModelProperty(value = "http请求头携带Token信息key", position = 2)
    public static final String TOKEN_HEADER = "authorization";
    /**
     * 缓存股票相关信息的cacheNames命名前缀
     */
    @ApiModelProperty(value = "缓存股票相关信息的cacheNames命名前缀", position = 3)
    public static final String STOCK = "stock";
}
