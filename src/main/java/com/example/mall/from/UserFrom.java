package com.example.mall.from;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户表单
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 23:36
 */
@Data
public class UserFrom {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
