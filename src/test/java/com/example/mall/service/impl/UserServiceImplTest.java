package com.example.mall.service.impl;

import com.example.mall.MallApplicationTests;
import com.example.mall.enums.RoleEnum;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/17 17:26
 */
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user = new User("jack","123456","jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}