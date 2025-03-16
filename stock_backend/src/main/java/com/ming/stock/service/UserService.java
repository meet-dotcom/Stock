package com.ming.stock.service;

import com.ming.stock.pojo.entity.SysUser;
import com.ming.stock.vo.req.LoginReqVo;
import com.ming.stock.vo.resp.LoginRespVo;
import com.ming.stock.vo.resp.R;
import io.swagger.annotations.ApiModel;

import java.util.Map;

/**
 * @Author: Ming
 * @Description 定义用户服务接口
 */
@ApiModel(description = "定义用户服务接口")
public interface UserService {
    /**
     * 根据用户名称查询用户信息
     * @return
     */
    SysUser getUserByUserName(String userName);

    /**
     * 用户登录功能
     * @param vo
     * @return
     */
    R<LoginRespVo> login(LoginReqVo vo);
    /**
     * 生成验证码的功能
     * @return
     */
    R<Map> getCaptchaCode();
}
