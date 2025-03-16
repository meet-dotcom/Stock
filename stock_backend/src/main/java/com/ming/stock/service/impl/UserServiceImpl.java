package com.ming.stock.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.google.common.base.Strings;
import com.ming.stock.pojo.entity.SysPermission;
import com.ming.stock.service.PermissionService;
import com.ming.stock.service.UserService;
import com.ming.stock.constant.StockConstant;
import com.ming.stock.mapper.SysUserMapper;
import com.ming.stock.pojo.entity.SysUser;
import com.ming.stock.utils.IdWorker;
import com.ming.stock.vo.req.LoginReqVo;
import com.ming.stock.vo.resp.LoginRespVo;
import com.ming.stock.vo.resp.PermissionRespNodeVo;
import com.ming.stock.vo.resp.R;
import com.ming.stock.vo.resp.ResponseCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: Ming
 * @Description 定义用户服务实现
 */
@ApiModel(description = "定义用户服务实现")
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @ApiModelProperty(hidden = true)
    @Autowired
    private SysUserMapper sysUserMapper;
    @ApiModelProperty(hidden = true)
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ApiModelProperty(hidden = true)
    @Autowired
    private RedisTemplate redisTemplate;
    @ApiModelProperty(hidden = true)
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private PermissionService permissionService;

    /**
     * 根据用户名称查询用户信息
     * @return
     */
    @Override
    public SysUser getUserByUserName(String userName) {
        SysUser user = sysUserMapper.findByUserName(userName);
        return user;
    }

    /**
     * 用户登录功能
     * @param vo
     * @return
     */
    @Override
    public R<LoginRespVo> login(LoginReqVo vo) {
        //判断参数是否合法
        if (vo == null || Strings.isNullOrEmpty(vo.getUsername())
                || Strings.isNullOrEmpty(vo.getPassword())
                || Strings.isNullOrEmpty(vo.getSessionId())
                || Strings.isNullOrEmpty(vo.getCode())) {
            return R.error(ResponseCode.USERNAME_OR_PASSWORD_ERROR.getMessage());
        }
        //从程序执行的效率看，先进行校验码的校验，成本较低
        //补充：根据传入的rkye 从redis中获取校验码
        //校验验证码和sessionId是否有效
        String rCheckCode = (String) redisTemplate.opsForValue().get(StockConstant.CHECK_PREFIX +vo.getSessionId());
        if (rCheckCode==null || ! rCheckCode.equalsIgnoreCase(vo.getCode())) {
            //响应验证码输入错误
            return R.error(ResponseCode.CHECK_CODE_ERROR.getMessage());
        }
        //是否需要添加手动淘汰redis缓存的数据，如果想快速淘汰，则可手动删除
        redisTemplate.delete("CK:" + vo.getSessionId());
        //2.根据用户名查询用户信息
        SysUser user = sysUserMapper.findByUserName(vo.getUsername());
        //3.判断用户是否存在
        if (user == null) {
            //用户不存在
            return R.error(ResponseCode.ACCOUNT_NOT_EXISTS.getMessage());
        }
        //4.调用密码匹配器匹配输入的明文密码和数据库的密文密码
        boolean isSuccess = passwordEncoder.matches(vo.getPassword(), user.getPassword());
        //4.1如果密码匹配不成功
        if (! isSuccess){
            return R.error(ResponseCode.ACCOUNT_NOT_EXISTS.getMessage());
        }
        //4.2成功则返回用户的正常信息
        LoginRespVo respVo = new LoginRespVo();
//        respVo.setUsername(user.getUsername());
//        respVo.setNickName(user.getNickName());
//        respVo.setPhone(user.getPhone());
//        respVo.setId(user.getId());
        //发现LoginRespVo与SysUser对象属性名称和类型一致
        //属性名称与类型必须相同，否则属性值无法copy
        BeanUtils.copyProperties(user, respVo);
        //获取指定用户的权限集合 添加获取侧边样数据和按钮权限的结合信息
        List<SysPermission> permissions = permissionService.getPermissionByUserId(user.getId());
        //获取树状权限菜单数据
        List<PermissionRespNodeVo> tree = permissionService.getTree(permissions,"0",true);
        //获取菜单按钮集合
        List<String> authBthPerms = permissions.stream().filter(per -> !Strings.isNullOrEmpty(per.getCode()) && per.getType() == 3)
                .map(per -> per.getCode()).collect(Collectors.toList());
        respVo.setMenus(tree);
        respVo.setPermissions(authBthPerms);
        //后期 用jwt生成token
        respVo.setAccessToken(user.getId()+":"+user.getUsername());

        return R.ok(respVo);
    }

    /**
     * 生成验证码的功能
     * @return
     */
    @Override
    public R<Map> getCaptchaCode() {
        //生成图片验证码 参数分别是  图片宽   图片高   字符个数   干扰线数
        LineCaptcha captcha =
                CaptchaUtil.createLineCaptcha(250, 40, 4, 5);
        //生成背景颜色  青灰色
        captcha.setBackground(Color.GREEN);
        //获取图片中的验证码，默认验证码包含字母数字，长度为4
        String checkCode = captcha.getCode();
        //获取经过base64编码处理的图片数据
        String imageData = captcha.getImageBase64();
        //生成sessionId转化成String,避免前端精度丢失
        String sessionId = String.valueOf(idWorker.nextId());
        //日志打印，生成日志文件
        log.info("当前生成的图片校验码:{},会话id:{}",checkCode,sessionId);
        //将sessionId做为key,校验码作为value保存在redis下（使用redis模拟session的行为，通过过期时间设置）
        redisTemplate.opsForValue().set(StockConstant.CHECK_PREFIX+sessionId,checkCode,5, TimeUnit.MINUTES);
        //最后组装响应数据
        HashMap<String,String> data = new HashMap<>();
        data.put("imageData",imageData);
        data.put("sessionId",sessionId);
        //响应
        return R.ok(data);
    }
}
