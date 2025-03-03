package com.springtrans.controlle;

import com.springtrans.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring手动操作事务
 */
@RequestMapping("/test")
@RestController
public class TestController {
     // JDBC 事务管理器
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    // 定义事务属性
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login")
    public String login(String name,String password){
// 开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
//⽤⼾注册
        Integer n = userInfoService.add(name, password);
//提交事务
       dataSourceTransactionManager.commit(transactionStatus);
//回滚事务
//        dataSourceTransactionManager.rollback(transactionStatus);
        return "注册成功";
    }

}
