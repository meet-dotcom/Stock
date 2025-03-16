package com.ming.stock.mapper;

import com.ming.stock.pojo.entity.SysLog;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author asus
* @description 针对表【sys_log(系统日志)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.SysLog
*/
@ApiModel(description = "针对表【sys_log(系统日志)】的数据库操作Mapper")
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<SysLog> findByCondition(@Param("username") String username, @Param("operation") String operation,
                                 @Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据角色id批量删除用户信息
     * @param logIds
     */
    int deleteBatchByLogIds(@Param("logIds") List<Long> logIds);}
