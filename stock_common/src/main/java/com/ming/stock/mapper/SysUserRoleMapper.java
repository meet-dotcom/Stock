package com.ming.stock.mapper;

import com.ming.stock.pojo.entity.SysUserRole;
import io.swagger.annotations.ApiModel;

/**
* @author asus
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.SysUserRole
*/
@ApiModel(description = "针对表【sys_user_role(用户角色表)】的数据库操作Mapper")
public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

}
