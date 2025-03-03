package com.springtrans.controlle;

import com.springtrans.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 自动执行事务,在 方法/类 上添加@Transactional注解
 */
@RequestMapping("/trans")
@RestController
public class TransactionalController {
    @Autowired
    private UserInfoService userInfoService;
    //事务提交
    @Transactional
    @RequestMapping("/login")
    public Boolean login(String name,String password){
        Integer n = userInfoService.add(name, password);
        if(n>0){
            return true;
        }else
            return false;
    }

    /**
     *发生 运行时异常/error 时,若try-catch捕获了异常,方法被认为是成功执行的,则会进行事务提交
     *              若 未捕获异常,或将异常throw抛出,会进行事务回滚
     *    若将异常捕获了,还想要事务回滚,可以再次将异常抛出,或者手动进行事务回滚
     * 若发生其他异常,事务都会提交,不会回滚,
     * 若想要回滚,可通过设置@Transactional的rollbackFor属性,对特定异常事务回滚
     */
    // 发生运行时异常,未捕获 :事务回滚
    @Transactional
    @RequestMapping("/l2")
    public Boolean l2(String name,String password){
        Integer n = userInfoService.add(name, password);
        int m= 10/0;
        if(n>0){
            return true;
        }else
            return false;
    }
    //发生 运行时异常,try-catch捕获 :事务提交
    @Transactional
    @RequestMapping("/l3")
    public Boolean l3(String name,String password){
        Integer n = userInfoService.add(name, password);
        try{
            int m= 10/0;
        }catch(Exception e){
            e.printStackTrace();
        }
        if(n>0){
            return true;
        }else
            return false;
    }
    //发生 运行时异常,try-catch捕获 :事务提交
//    想要事务回滚,1.进行抛出异常 :事务回滚
    @Transactional
    @RequestMapping("/l31")
    public Boolean l31(String name,String password){
        Integer n = userInfoService.add(name, password);
        try{
            int m= 10/0;
        }catch(Exception e){
            throw e;
        }
        if(n>0){
            return true;
        }else
            return false;
    }
    //发生 运行时异常,try-catch捕获 :事务提交
//    想要事务回滚,2.手动进行事务回滚 :事务回滚
    @Transactional
    @RequestMapping("/l32")
    public Boolean l32(String name,String password){
        Integer n = userInfoService.add(name, password);
        try{
            int m= 10/0;
        }catch(Exception e){
//            TransactionAspectSupport.currentTransactionStatus()：获取到当前事务
//            设置setRollbackOnly(),手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        if(n>0){
            return true;
        }else
            return false;
    }

//发生 非运行时异常,将异常try-catch捕获 :事务提交
    @Transactional
    @RequestMapping("/l4")
    public Boolean l4(String name,String password) {
        Integer n = userInfoService.add(name, password);
        if(true){
            try {
               throw new IOException();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(n>0){
            return true;
        }else
            return false;
    }
    //发生 非运行时异常,将异常throw抛出 :事务提交
    @Transactional
    @RequestMapping("/l5")
    public Boolean l5(String name,String password) throws IOException {
        Integer n = userInfoService.add(name, password);
        if(true){
            throw new IOException();
        }
        if(n>0){
            return true;
        }else
            return false;
    }
    //rollbackFor:指定触发回滚的异常 :事务回滚
    @Transactional(rollbackFor = IOException.class)
    @RequestMapping("/l6")
    public Boolean l6(String name,String password) throws IOException {
        Integer n = userInfoService.add(name, password);
        if(true){
            throw new IOException();
        }
        if(n>0){
            return true;
        }else
            return false;
    }

}
