package com.ming.stock.sharding;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.joda.time.DateTime;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 定义公共的算法类：覆盖个股、大盘、
 */
public class CommonAlgDb implements PreciseShardingAlgorithm<Date>, RangeShardingAlgorithm<Date> {
    /**
     * 精准查询
     * 分库策略：安装年分库
     * 精准查询的时候走该方法 cur_time条件必须是=或者in
     * @param dbNames    获取数据源集合 ds-2022,  ds-2023,ds-2024
     * @param shardingValue 封装逻辑表，分片列名称，条件值等
     * @return
     */
    @Override
    public String doSharding(Collection<String> dbNames, PreciseShardingValue<Date> shardingValue) {
        //获取逻辑表的名称  t_user
        String logicTableName = shardingValue.getLogicTableName();
        //获取数据库指定的分键片名称:  cur_time
        String columnName = shardingValue.getColumnName();
        //获取此时查询时的片键值  条件值
        Date curTime = shardingValue.getValue();
        //自定义算法  根据传入的值，找对应的数据源
        //获取数据源下标
        String year = new DateTime(curTime).getYear()+"";
        Optional<String> result = dbNames.stream().filter(dsName -> dsName.endsWith(year)).findFirst();
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    /**
     * 根据片键的范围匹配数据库
     * @param dsNames 所有数据源的名称集合
     * @param shardingValue 片键信息的封装
     * @return 当前数据库查询名称的数据库集合
     * select * form xxx   where   between xx and xx
     */
    @Override
    public Collection<String> doSharding(Collection<String> dsNames, RangeShardingValue<Date> shardingValue) {
        //获取分片键名称
        String columnName = shardingValue.getColumnName();
        //获取逻辑表
        String logicTableName = shardingValue.getLogicTableName();
        //对范围数据的封装
        Range<Date> valueRange = shardingValue.getValueRange();
        //判断是否有范围查询的起始值
        if (valueRange.hasLowerBound()) {
            //获取起始值
            Date startTime = valueRange.lowerEndpoint();//10
            int startYear = new DateTime(startTime).getYear();
            //过滤出数据源中大于等于startYear
            dsNames = dsNames.stream().filter(
                    dsName->Integer.parseInt(dsName.substring(dsName.lastIndexOf("-")+1))>=startYear)
                    .collect(Collectors.toList());

        }
        //判断是否有上限值
        if (valueRange.hasUpperBound()) {
            Date endTime = valueRange.upperEndpoint();
            //获取条件所属年份
            int endYear = new DateTime(endTime).getYear();
            dsNames = dsNames.stream().filter(
                            dsName->Integer.parseInt(dsName.substring(dsName.lastIndexOf("-")+1))<=endYear)
                    .collect(Collectors.toList());
        }
        //一般会根据start和end值找符合条件的数据源集合
        return dsNames;
    }
}
