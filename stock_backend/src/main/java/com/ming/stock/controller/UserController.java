package com.ming.stock.controller;

import com.ming.stock.service.UserService;
import com.ming.stock.vo.req.LoginReqVo;
import com.ming.stock.vo.resp.LoginRespVo;
import com.ming.stock.vo.resp.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ming.stock.pojo.entity.SysUser;
import java.util.Map;

/**
 * @Author: Ming
 * @Description 定义用户服务接口
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户相关处理接口")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @ApiOperation(value = "根据用户名查询用户信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "name",
                    value = "用户名",required = true,type = "path")})
    @GetMapping("/user/{userName}")
    public SysUser getUserByUserName(@PathVariable("userName") String userName){
        return userService.getUserByUserName(userName);
    }
/*    @ApiOperation(value = "用户登录功能")
    @PostMapping("/login")
    public R<LoginRespVo> login(@RequestBody LoginReqVo vo){
        return userService.login(vo);
    }*/

    /**
     * 生成验证码的功能
     * @return
     */
    @ApiOperation(value = "生成验证码的功能")
    @GetMapping("/captcha")
    public R<Map> getCaptchaCode(){
        return userService.getCaptchaCode();
    }




}
