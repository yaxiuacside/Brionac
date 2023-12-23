package com.brionac.common;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result<?> exceptionHandler(Exception e){
        System.out.println("全局异常捕获>>>:"+e);
        return Result.error("500",e.getMessage());
    }
}
