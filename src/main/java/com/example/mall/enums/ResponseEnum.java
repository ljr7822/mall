package com.example.mall.enums;

import lombok.Getter;

/**
 * 返回的代码枚举类
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 23:19
 */
@Getter
public enum ResponseEnum {

    /**
     * 服务端错误
     */
    ERROR(-1,"服务端错误"),

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     *密码错误
     */
    PASSWORD_ERROR(1,"密码错误"),

    /**
     * 用户名已存在
     */
    USERNAME_EXIST(2,"用户名已存在"),

    /**
     * 邮箱已存在
     */
    EMAIL_EXIST(4,"邮箱已存在"),

    /**
     * 参数错误
     */
    PARAM_ERROR(3,"参数错误"),

    /**
     * 用户未登录,请先登录
     */
    NEED_LOGIN(10,"用户未登录,请先登录"),

    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
