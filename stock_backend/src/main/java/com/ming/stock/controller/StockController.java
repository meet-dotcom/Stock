package com.ming.stock.controller;

import com.ming.stock.pojo.domain.*;
import com.ming.stock.service.StockService;
import com.ming.stock.vo.resp.PageResult;
import com.ming.stock.vo.resp.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quot")
public class StockController {
    @Autowired
    private StockService stockService;

    /**
     * 获取国内大盘数据
     * @return
     */
    @GetMapping("/index/all")
    public R<List<InnerMarketDomain>> getInnerMarketInfo(){
        return stockService.getInnerMarketInfo();
    }

    /**
     * 分页查询股票最新数据，并按照涨幅排序查询
     * @param page  当前页
     * @param pageSize  分页大小
     * 涨幅榜页面的“查看更多”
     * @return
     */
    @GetMapping("/stock/all")
    public R<PageResult<StockUpdownDomain>> getStockPageInfo(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                                             @RequestParam(name = "pageSize",required = false,defaultValue = "20") Integer pageSize){
        return stockService.getStockPageInfo(page,pageSize);
    }



    /**
     * 统计最新股票交易日内每分钟涨跌停的股票数量
     * @return
     */
    @GetMapping("/stock/updown/count")
    public R<Map<String,List>> getStockUpdownCount(){
        return stockService.getStockUpdownCount();
    }

    /**
     * 将指定页的股票数据导出到excel表下
     * @param page 当前页
     * @param pageSize 每页大小
     * @param response
     */
    @GetMapping("/stock/export")
    public void exportStockUpDownInfo(
            @RequestParam(name="page",required = false,defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "20") Integer pageSize,
            HttpServletResponse response){
        stockService.exportStockUpDownInfo(page,pageSize,response);

    }

    /**
     * 统计A股大盘T日和T-1日成交量对比功能（成交量为深沪两市成交量之和） 大盘每分钟成交量数据
     * @return
     */
    @GetMapping("/stock/tradeAmt")
    public R<Map<String,List>> getComparedStockTradeAmt(){
        return stockService.getComparedStockTradeAmt();
    }

    /**
     * 统计最新交易时间点下的股票（A股） 在各个涨幅区间的数量
     * @return
     */
    @GetMapping("/stock/updown")
    public R<Map> getIncreaseRangeInfo(){
        return stockService.getIncreaseRangeInfo();
    }


    /**
     * 功能描述：查询单个个股的分时行情数据，也就是统计股票T日每分钟的交易数据
     * 如果当前日期不在有效时间范围内，则以最近的一个股票交易时间作为查询时间点
     * 总结：获取指定股票T日分时数据
     * @param stockCode     股票编码
     * @return
     */
    @GetMapping("/stock/screen/time-sharing")
    public R<List<Stock4MinuteDomain>> getStockScreenTimeSharing(
            @RequestParam(value = "code",required = true) String stockCode){
        return stockService.getStockScreenTimeSharing(stockCode);

    }

    /**
     * 单个个股日K  数据查询  可以根据区间查询日的K线数据
     * @param stockCode     股票编码
     * @return
     */
    @GetMapping("/stock/screen/dkline")
    public R<List<Stock4EvrDayDomain>> getStockScreenDkLine(
            @RequestParam(value = "code",required = true) String stockCode){
        return stockService.getStockScreenDkLine(stockCode);
    }
    /**
     * 外盘数据展示
     * @return
     */
    @ApiOperation(value = "外盘数据", notes = "外盘数据", httpMethod = "GET")
    @GetMapping("/external/index")
    public R<List<OutMarketDomain>> getOutMarket(){
        return stockService.getOutMarket();
    }

    /**
     *需求说明: 获取沪深两市板块最新数据，以交易总金额降序查询，取前10条数据
     * @return
     */
    @GetMapping("/sector/all")
    public R<List<StockBlockDomain>> sectorAll(){
        return stockService.sectorAllLimit();
    }

    /**
     * 统计沪深两市个股最新交易数据，并按涨幅降序排序查询前4条数据
     * @return
     */
    @ApiOperation(value = "统计沪深两市个股最新交易数据，并按涨幅降序排序查询前4条数据", notes = "无请求参数", httpMethod = "GET")
    @GetMapping("/stock/increase")
    @ResponseBody
    public R<List<StockUpdownDomain>> getTopStocksByIncrease() {
        return stockService.getTopStocksByIncrease();
    }

}
