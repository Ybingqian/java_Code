package com.springioc.configuration;

import com.springioc.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {
//   1.通过@Primary注解解决 当注入的类有多个Bean时
//    @Primary:指定该Bean为默认Bean的实现
    @Primary
    @Bean
    public User user1(){
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    @Bean
    public User USER2(){
        User user = new User();
        user.setName("lisi");
        return user;
    }
    @Bean
    public User UserInfo(){
        User user = new User();
        user.setName("didi");
        return user;
    }
//    给bean重命名
//    @Bean(name={"u3","user3"})
//   1.{}中可以有多个字符串,name的参数为字符串数组
//    2."name=" 可以省略,只有一个名字时,{}也可以省略不写
    @Bean("u3")
    public User User3(){
        User user = new User();
        user.setId(10);
        user.setName("zhangsan");
        return user;
    }


}
