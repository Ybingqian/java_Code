package com.springaop.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 注解
 */
@Target(ElementType.METHOD) //注解使用位置:方法上
@Retention(RetentionPolicy.RUNTIME) //注解生命周期:最长 整个生命周期,丛生到死
public @interface MyAspect {

}
