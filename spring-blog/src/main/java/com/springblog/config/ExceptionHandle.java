package com.springblog.config;

import com.springblog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e){
        log.error("统一异常处理错误: e:",e);
        return Result.fail("内部发生错误,请联系管理员!");
    }

}
