package com.example.mall.controller;

import com.example.mall.from.UserFrom;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import com.example.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 22:30
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册
     * 1.通过 ‘@RequestParam String username‘ 获得参数
     * 2.通过 ’User user‘
     * 3.通过 ’@RequestBody User user‘ 接收json格式的参数
     */
    @PostMapping("/register")
    public ResponseVo register(@RequestBody UserFrom userFrom, BindingResult bindingResult) {
        // 1.判断传入数据是否为空
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误 {}", Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        User user = new User();
        BeanUtils.copyProperties(userFrom, user);
        return userService.register(user);
    }
}
