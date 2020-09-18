package com.example.mall.enums;

import lombok.Getter;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/17 17:33
 */
@Getter
public enum RoleEnum {
    /**
     * 管理员
     */
    ADMIN(0),
    /**
     * 普通用户
     */
    CUSTOMER(1),
    ;

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
