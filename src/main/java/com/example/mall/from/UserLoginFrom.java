package com.example.mall.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录表单
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 23:36
 */
@Data
public class UserLoginFrom {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;
}
