package com.springtrans.service;

import com.springtrans.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     *1.当传播机制为 Required时,
     * 所有事务和为一个事物,同生共死,
     * 若其中有一个事务触发异常,若对异常事务进行手动回滚,则所有事务都会回滚
     */

    /**4.当传播机制为 Required_new时,
     * 不论是否有事务,都会创建新的事物,事物之间相互独立,互不干扰,
     */

    /**6.当传播机制为 never 时,
     *  以非事务方式运行,不允许存在事务,若当前存在事务,则抛出异常
     */

    /**2.当传播机制为 support 时,
     * 若当前存在事务,则加入该事务
     * 若当前没有事务,则以非事务方式运行
     */

     /**5.当传播机制为 not_support 时,
         * 以非事务方式运行,
          * 若当前存在事务,则将其挂起,
         * 若当前没有事务,则以非事务方式运行
         */

    /**3.当传播机制为 mandatory 时,
     * 必须存在事务
     * 若当前存在事务,则加入事务,若没有事务,则抛出异常
     */

    /**7.当传播机制为 nested 时,
     * 若当前不存在事务,和required机制相同,创建新的事物
     * 若存在事务: 原来的事务存在,并创建了新的事务,各个事务相互独立,互不影响(包括原来的事务)
     * 若其中的一个事务发生异常,需要回滚,不影响别的事务的提交
     */

    @Transactional(propagation = Propagation.NESTED)
    public Integer insert(String name,String op){
        Integer log = logInfoMapper.insert(name, op);
        try{
            int a=10/0;
        }catch(Exception e){
            e.printStackTrace();
//            手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return log;
    }

}
