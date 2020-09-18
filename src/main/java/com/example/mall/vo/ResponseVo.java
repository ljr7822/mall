package com.example.mall.vo;

import com.example.mall.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * 返回数据格式类
 *
 * @Author: iwen大大怪
 * @DateTime: 2020/9/18 22:55
 */
@Data
//@JsonSerialize(include = )
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 成功时返回json格式数据(有参)
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> success(String msg) {
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    /**
     * 成功时返回json格式数据(无参)
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> success() {
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    /**
     * 错误时返回json格式数据(有参)
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        return new ResponseVo<>(responseEnum.getCode(), responseEnum.getDesc());
    }

    /**
     * 错误时返回json格式数据(多参)
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, String msg) {
        return new ResponseVo<>(responseEnum.getCode(), msg);
    }

    /**
     * 错误时返回json格式数据(多参)
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult) {
        return new ResponseVo<>(responseEnum.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }
}
