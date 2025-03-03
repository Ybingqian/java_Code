package com.springtrans.controlle;

import com.springtrans.service.LogInfoService;
import com.springtrans.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user2")
@RestController
public class User2Controller {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LogInfoService logInfoService;

//    @Transactional
    @RequestMapping("/resign")
    public Boolean resign(String name,String password){
        Integer i = userInfoService.add(name, password);
        System.out.println("用户注册: "+i);
        Integer j = logInfoService.insert(name, "插入一条数据");
        System.out.println("日志记录: "+j);
        try{
            int a=10/0;
        }catch(Exception e){
            e.printStackTrace();
//            手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return (i>0 && j>0);
    }
}
