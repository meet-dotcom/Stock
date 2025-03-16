package com.ming.stock.mapper;

import com.ming.stock.pojo.domain.StockBlockDomain;
import com.ming.stock.pojo.entity.StockBlockRtInfo;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author asus
* @description 针对表【stock_block_rt_info(股票板块详情信息表)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.StockBlockRtInfo
*/
@ApiModel(description = "针对表【stock_block_rt_info(股票板块详情信息表)】的数据库操作Mapper")
public interface StockBlockRtInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockBlockRtInfo record);

    int insertSelective(StockBlockRtInfo record);

    StockBlockRtInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockBlockRtInfo record);

    int updateByPrimaryKey(StockBlockRtInfo record);

    List<StockBlockDomain> sectorAllLimit(@Param("timePoint") Date timePoint);

    int insertBatch(List<StockBlockRtInfo> list);
}
