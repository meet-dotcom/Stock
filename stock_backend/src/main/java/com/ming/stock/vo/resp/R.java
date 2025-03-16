package com.ming.stock.vo.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: Ming
 * @Description: 返回数据类
 * @JsonInclude 保证序列化json的时候,如果是null的对象,key也会消失
 **/
@ApiModel(description = ": 返回数据类*/")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {
    private static final long serialVersionUID = 7735505903525411467L;

    // 成功值,默认为1
    @ApiModelProperty(value = "成功值,默认为1", position = 2)
    private static final int SUCCESS_CODE = 1;
    // 失败值,默认为0
    @ApiModelProperty(value = "失败值,默认为0", position = 3)
    private static final int ERROR_CODE = 0;

    //状态码
    @ApiModelProperty(value = "状态码", position = 4)
    private int code;
    //消息
    @ApiModelProperty(value = "消息", position = 5)
    private String msg;
    //返回数据
    @ApiModelProperty(value = "返回数据", position = 6)
    private T data;

    private R(int code){
        this.code = code;
    }
    private R(int code, T data){
        this.code = code;
        this.data = data;
    }
    private R(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private R(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok(){
        return new R<T>(SUCCESS_CODE,"success");
    }
    public static <T> R<T> ok(String msg){
        return new R<T>(SUCCESS_CODE,msg);
    }
    public static <T> R<T> ok(T data){
        return new R<T>(SUCCESS_CODE,data);
    }
    public static <T> R<T> ok(String msg, T data){
        return new R<T>(SUCCESS_CODE,msg,data);
    }

    public static <T> R<T> error(){
        return new R<T>(ERROR_CODE,"error");
    }
    public static <T> R<T> error(String msg){
        return new R<T>(ERROR_CODE,msg);
    }
    public static <T> R<T> error(int code, String msg){
        return new R<T>(code,msg);
    }
    //ResponseCode 枚举类 里面有多个数据
    public static <T> R<T> error(ResponseCode res){
        return new R<T>(res.getCode(),res.getMessage());
    }

    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }
}
