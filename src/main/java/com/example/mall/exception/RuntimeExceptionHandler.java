package com.example.mall.exception;

import com.example.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.mall.enums.ResponseEnum.ERROR;

/**
 * 异常捕获类
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/19 1:08
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ERROR,e.getMessage());
    }

}
