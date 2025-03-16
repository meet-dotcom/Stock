package com.ming.stock.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ming
 * @Description 登录请求vo
 */
@ApiModel(description = "登录请求vo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginReqVo {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", position = 1)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", position = 2)
    private String password;
    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", position = 3)
    private String code;
    /**
     * 会话ID
     */
    @ApiModelProperty(value = "会话ID", position = 4)
    private String sessionId;
}
