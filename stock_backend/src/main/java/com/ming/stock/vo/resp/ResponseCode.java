package com.ming.stock.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Ming
 * @Description: TODO
 **/
@ApiModel(description = ": TODO*/")
public enum ResponseCode{
    @ApiModelProperty(hidden = true) ERROR(0,"操作失败"),
    @ApiModelProperty(hidden = true) SUCCESS(1,"操作成功"),
    @ApiModelProperty(hidden = true) DATA_ERROR(0,"参数异常"),
    @ApiModelProperty(hidden = true) NO_RESPONSE_DATA(0,"无响应数据"),
    @ApiModelProperty(hidden = true) CHECK_CODE_NOT_EMPTY(0,"验证码不能为空"),
    @ApiModelProperty(hidden = true) CHECK_CODE_ERROR(0,"验证码错误"),
    @ApiModelProperty(hidden = true) USERNAME_OR_PASSWORD_ERROR(0,"用户名或密码错误"),
    @ApiModelProperty(hidden = true) ACCOUNT_EXISTS_ERROR(0,"该账号已存在"),
    @ApiModelProperty(hidden = true) ACCOUNT_NOT_EXISTS(0,"该账号不存在"),
    @ApiModelProperty(hidden = true) TOKEN_ERROR(2,"用户未登录，请先登录"),
    @ApiModelProperty(hidden = true) NOT_PERMISSION(3,"没有权限访问该资源"),
    @ApiModelProperty(hidden = true) ANONMOUSE_NOT_PERMISSION(0,"匿名用户没有权限访问"),
    @ApiModelProperty(hidden = true) INVALID_TOKEN(0,"无效的票据"),
    @ApiModelProperty(hidden = true) OPERATION_MENU_PERMISSION_CATALOG_ERROR(0,"操作后的菜单类型是目录，所属菜单必须为默认顶级菜单或者目录"),
    @ApiModelProperty(hidden = true) OPERATION_MENU_PERMISSION_MENU_ERROR(0,"操作后的菜单类型是菜单，所属菜单必须为目录类型"),
    @ApiModelProperty(hidden = true) OPERATION_MENU_PERMISSION_BTN_ERROR(0,"操作后的菜单类型是按钮，所属菜单必须为菜单类型"),
    @ApiModelProperty(hidden = true) OPERATION_MENU_PERMISSION_URL_CODE_NULL(0,"菜单权限的按钮标识不能为空"),
    @ApiModelProperty(hidden = true) ROLE_PERMISSION_RELATION(0, "该菜单权限存在子集关联，不允许删除");
    @ApiModelProperty(hidden = true)
    private int code;
    @ApiModelProperty(hidden = true)
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
