package com.ming.stock.mapper;

import com.ming.stock.pojo.entity.SysRole;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author asus
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2024-12-23 19:07:52
* @Entity com.ming.stock.pojo.entity.SysRole
*/
@ApiModel(description = "针对表【sys_role(角色表)】的数据库操作Mapper")
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectAll();

    List<SysRole> getRoleByUserId(@Param("userId") String userId);
}
