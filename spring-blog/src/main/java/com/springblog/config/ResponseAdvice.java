package com.springblog.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springblog.model.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一结果返回
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    private static ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
// 判断beforeBodyWrite方法是否执行
//       返回: true:方法执行, false: 方法不执行
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof Result){
//            当结果已经是 Result类型,直接返回body,不要再进行二次封装
            return body;
        }else if(body instanceof String){
//            当结果为字符串类型时,需要使用SpringBoot内置的jackson将信息进行 序列化
            try {
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return Result.success(body);
    }
}
