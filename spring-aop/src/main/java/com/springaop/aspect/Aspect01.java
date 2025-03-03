package com.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
//@Component
@Aspect
@Slf4j
@Order(10)
public class Aspect01 {
    /**
     * 不同的切面类型的执行顺序:正常情况: Around.before > Before > AfterReturning > After >Around.after
     *                      异常情况: Around.before > Before > AfterThrowing > After
     */
////    环绕通知
//    @Around("execution(* com.springaop.controller.*.*(..))")
//    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
////      记录⽅法执⾏开始时间
//        long begin = System.currentTimeMillis();
////      执⾏原始⽅法
//        Object result = pjp.proceed();
////      记录⽅法执⾏结束时间
//        long end = System.currentTimeMillis();
////      记录⽅法执⾏耗时
//        long time=end-begin;
//        log.info(pjp.getSignature() + "执⾏耗时: {}ms", end - begin);
//        return result;
//    }

    /**
     * 切面的优先级: 默认按照 类名称排序
     * 使用@Order(n)注解,指定优先级,数字越小优先级越高
     */


    /**
//    定义公共切点：@Pointcut注解
//    当把公共切点定义成private时,只能在本类中使用;
//    定义成public时,可以在类外方法中使用,类外使用公共切点时,需要引用切点的 全限定名
     */
    @Pointcut("execution(* com.springaop.controller.*.*(..))")
    public  void pt(){}
//调用公共切点:
//    @Before("pt()")
    public void before(){
        log.info("aspect01 pt() before");
    }
    //    环绕通知 :通知方法在目标方法前后都执行
//      Around通知,需要调用ProceedingJoinPoint.process()方法,让目标方法执行,别的通知类型不需要
//      方法必须要有返回结果,否则若连接点有返回值时,调用时无返回结果
    @Around("execution(* com.springaop.controller.*.*(..))")
    public Object aroundAspect(ProceedingJoinPoint pjp) throws Throwable {
        log.info("aspect01 around before..");
//      执⾏原始⽅法
        Object result = pjp.proceed();
        log.info("aspect01 around after...");
        return result;
    }
//    前置通知 :通知方法在目标方法前执行
    @Before("execution(* com.springaop.controller.*.*(..))")
    public void beforeAspest(){
        log.info("aspect01 before aspect...");
    }
//    后置通知 :通知在目标方法后执行,不论是否发生异常都会执行
    @After("execution(* com.springaop.controller.*.*(..))")
    public void afterAspest(){
        log.info("aspect01 after aspect...");
    }
//  返回后通知: 通知方法在目标方法执行后执行,发生异常时,该方法不再执行
    @AfterReturning("execution(* com.springaop.controller.*.*(..))")
    public void afterReturningAspest(){
        log.info("aspect01 after return aspect...");
    }
//    异常后通知: 通知方法在目标方法发生异常后执行
    @AfterThrowing("execution(* com.springaop.controller.*.*(..))")
    public void afterThrowingAspest(){
        log.info("aspect01 after throw aspect...");
    }
}
