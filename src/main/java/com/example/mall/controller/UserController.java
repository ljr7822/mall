package com.example.mall.controller;

import com.example.mall.from.UserLoginFrom;
import com.example.mall.from.UserRegisterFrom;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import com.example.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

import static com.example.mall.consts.MallConst.CURRENT_USER;
import static com.example.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 22:30
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册控制器
     * 1.通过 ‘@RequestParam String username‘ 获得参数
     * 2.通过 ’User user‘
     * 3.通过 ’@RequestBody User user‘ 接收json格式的参数
     */
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterFrom userRegisterFrom, BindingResult bindingResult) {
        // 1.判断传入数据是否为空
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误 {}", Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterFrom, user);
        return userService.register(user);
    }

    /**
     * 登录控制器
     *
     * @param userLoginFrom 登录表单
     * @param bindingResult
     * @return
     */
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginFrom userLoginFrom,
                                  BindingResult bindingResult, HttpSession session) {
        // 1.判断传入数据是否为空
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误 {}", Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLoginFrom.getUsername(), userLoginFrom.getPassword());

        // 设置session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());

        // 打印session
        log.info("login session = {}", session.getId());

        return userResponseVo;
    }

    /**
     * 获取用户信息控制器
     * session保存在内存中，很容易丢失，一般会保存到redis中
     * 改进版本：token+redis
     *
     * @param session
     * @return
     */
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        // 打印session
        log.info("/user session = {}", session.getId());

        User user = (User) session.getAttribute(CURRENT_USER);

        return ResponseVo.success(user);
    }

    //TODO 判断登录状态，拦截器
    /**
     * 退出登录
     * {@link TomcatServletWebServerFactory} getSessionTimeoutInMinutes
     * @param session 传入
     * @return
     */
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        // 打印session
        log.info("/user/logout = {}", session.getId());

        // 登出
        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();

    }
}
