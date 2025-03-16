package com.ming.stock.mapper;

import com.ming.stock.pojo.entity.StockBusiness;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
* @author asus
* @description 针对表【stock_business(主营业务表)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.StockBusiness
*/
@ApiModel(description = "针对表【stock_business(主营业务表)】的数据库操作Mapper")
public interface StockBusinessMapper {

    int deleteByPrimaryKey(String id);

    int insert(StockBusiness record);

    int insertSelective(StockBusiness record);

    StockBusiness selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockBusiness record);

    int updateByPrimaryKey(StockBusiness record);

    /**
     * 获取所有的A股编码集合
     * @return
     */
    List<String> getStockIds();

}
