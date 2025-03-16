package com.ming.stock.mapper;

import com.ming.stock.pojo.entity.SysUser;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author asus
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.SysUser
*/
@ApiModel(description = "针对表【sys_user(用户表)】的数据库操作Mapper")
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByUserName(@Param("userName") String userName);

    List<SysUser> findAll();
}
