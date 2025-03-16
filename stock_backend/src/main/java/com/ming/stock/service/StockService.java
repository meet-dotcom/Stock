package com.ming.stock.service;

import com.ming.stock.pojo.domain.*;
import com.ming.stock.vo.resp.PageResult;
import com.ming.stock.vo.resp.R;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface StockService {
    /**
     * 获取国内大盘数据
     * @return
     */
    R<List<InnerMarketDomain>> getInnerMarketInfo();

    /**
     * 分页查询股票最新数据，并按照涨幅排序查询
     * @param page  当前页
     * @param pageSize  分页大小
     * @return
     */
    R<PageResult<StockUpdownDomain>> getStockPageInfo(Integer page, Integer pageSize);


    /**
     * 统计最新股票交易日内每分钟涨跌停的股票数量
     * @return
     */
    R<Map<String, List>> getStockUpdownCount();

    void exportStockUpDownInfo(Integer page, Integer pageSize, HttpServletResponse response);


    R<Map<String, List>> getComparedStockTradeAmt();

    /**
     * 统计最新交易时间点下的股票（A股） 在各个涨幅区间的数量
     * @return
     */
    R<Map> getIncreaseRangeInfo();

    /**
     * 功能描述：查询单个个股的分时行情数据，也就是统计股票T日每分钟的交易数据
     * 如果当前日期不在有效时间范围内，则以最近的一个股票交易时间作为查询时间点
     * 总结：获取指定股票T日分时数据
     * @param stockCode     股票编码
     * @return
     */
    R<List<Stock4MinuteDomain>> getStockScreenTimeSharing(String stockCode);


    R<List<Stock4EvrDayDomain>> getStockScreenDkLine(String stockCode);

    R<List<OutMarketDomain>> getOutMarket();

    R<List<StockBlockDomain>> sectorAllLimit();

    R<List<StockUpdownDomain>> getTopStocksByIncrease();
}
