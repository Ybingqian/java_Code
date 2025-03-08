package com.springblog.config;

import com.springblog.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    private final List excludePaths = Arrays.asList(
            "/**/*.html",
            "/blog-editormd/**",
            "/css/**",
            "/js/**",
            "/pic/**",
            "/user/login",
            "/favicon.ico",
            "/error"
    );
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
//                 注意:要对所有的路径进行拦截
                .addPathPatterns("/**")
                .excludePathPatterns(excludePaths);
    }
}
