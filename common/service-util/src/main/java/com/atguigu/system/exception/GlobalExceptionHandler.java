package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理类
 *
 * @author 陈江林
 * @date 2022/11/11 17:02
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    /**
     * 特定异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("算数运算异常!");
    }

    /**
     * 自定义异常处理
     *
     * @param e e
     * @return {@link Result}
     */
    @ExceptionHandler(GuiguException.class)
    public Result error(GuiguException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMessage());
    }

}
