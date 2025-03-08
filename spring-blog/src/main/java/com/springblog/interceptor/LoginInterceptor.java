package com.springblog.interceptor;

import com.springblog.constant.BlogConstants;
import com.springblog.model.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器,对未进行用户登录的操作进行统一拦截
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//      从header中获取Token
        String token = request.getHeader(BlogConstants.HEAD_TOKEN);
        log.info("header中获取到的Token为: {}",token);
//        验证用户Token
        Claims claims = JwtUtils.parseJWT(token);
//      判断
        if(claims != null){
            log.info("令牌验证通过,放行!");
            return true;
        }
        response.setStatus(401);
        log.error("令牌验证失败,返回401!");
        return false;

    }
}
