package com.example.mall;

import com.example.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.mall.consts.MallConst.CURRENT_USER;

/**
 * 拦截器
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/19 21:08
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler
     * @return true:表示继续；false：中断
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle:...");
        User user = (User) request.getSession().getAttribute(CURRENT_USER);
        if (user == null) {
            // 中断
            log.info("user = null");
            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }
}
