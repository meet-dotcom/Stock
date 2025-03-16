package com.ming.stock.service;


import com.ming.stock.vo.req.RoleAddVo;
import com.ming.stock.vo.req.RoleUpdateVo;
import com.ming.stock.vo.resp.PageResult;
import com.ming.stock.vo.resp.R;
import com.ming.stock.vo.resp.RolePageReqVo;

import java.util.Set;

/**
 * @author by Ming
 * @Description 角色服务接口
 */
public interface RoleService {

    /**
     * 分页查询当前角色信息
     * @param vo
     * @return
     */
    public R<PageResult> quryPageRole(RolePageReqVo vo);

    /**
     * 添加角色和角色关联权限
     * @param vo
     * @return
     */
    R<String> addRoleWithPermissions(RoleAddVo vo);

    /**
     * 根据角色id查找对应的权限id集合
     * @param roleId
     * @return
     */
    R<Set<String>> getPermissionIdsByRoleId(Long roleId);

    /**
     * 更新角色信息，包含角色关联的权限信息
     * @param vo
     * @return
     */
    R<String> updateRoleWithPermissions(RoleUpdateVo vo);

    /**
     * 根据角色id删除角色信息
     * @param roleId
     * @return
     */
    R<String> deleteRoleById(String roleId);

    /**
     * 更新用户的状态信息
     * @param roleId 角色id
     * @param status 状态 1.正常 0：启用
     * @return
     */
    R<String> updateRoleStatus(String roleId, Integer status);
}
