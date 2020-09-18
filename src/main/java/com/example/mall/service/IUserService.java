package com.example.mall.service;

import com.example.mall.pojo.User;
import com.example.mall.vo.ResponseVo;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/17 16:34
 */
public interface IUserService {
    /**
     * 注册
     */
    ResponseVo register(User user);

    /**
     * 登录
     */
}
