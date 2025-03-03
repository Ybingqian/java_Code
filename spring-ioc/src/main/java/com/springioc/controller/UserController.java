package com.springioc.controller;

import com.springioc.component.UserComponent;
import com.springioc.model.User;
import com.springioc.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//通过@Controller对类进行重命名.
@Controller("userController")//存储到spring中
public class UserController {
//    依赖注入:将Service类注入到Controller类中
    /**
    通过@Autowired注解注入,
        @Autowired是通过类型注入的,当查找到相同类型有多个Bean时,要再进行设置;
     *  只找到一个时,自动装配
     */
    /**
         注入法一: 属性注入
     * 优点:代码简单,使用方便
     * 缺点:只能在spring容器中使用,不能注入final修饰的属性
     */
//    @Autowired
//    private UserService userService;

    /**
//    2.通过构造方法注入
     * 优点:
     * 1.可以注入final修饰的属性
     * 2.注入的对象不会被修改
     * 3.注入的对象在使用前一定会被完全初始化,因为是在构造方法中注入的,构造方法是在类加载阶段完成的
     * 4.通用性好,构造方法是jdk支持的,更换任何框架都支持
     * 缺点:代码比较繁琐
     */
//    private UserService userService;
//    private UserComponent userComponent;
//    1.若该类只有一个构造方法时,@Autowired注解可以省略不写(规范写法要写);
//    2.若有多个构造方法,一定要写@Autowire的注解,否则找不到默认的构造函数
//    3.若显示写了默认构造函数(空的构造函数),未写@Autowired注解时,spring会从空的构造函数中取取Bean,
//      但由于空的构造函数中不存在Bean,就会报空指针异常
//    public UserController() {
//    }
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    public UserController(UserService userService, UserComponent userComponent) {
//        this.userService = userService;
//        this.userComponent = userComponent;
//    }
    /**
        3.通过set方法注入
     * 优点:⽅便在类实例之后, 重新对该对象进⾏配置或者注⼊
     * 缺点:
     * 1.不能注⼊⼀个Final修饰的属性
     * 2.注入的对象可能会被改变,因为set方法是可以通过调用获取到的.有被修改的风险
     */
//    若未写@Autowired注解,会报空指针异常
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 当注入的类有多个Bean时,会在获取的时候找到了多个Bean,但只能获取一个Bean而发生报错.(非唯一的Bean对象)
     * 可以通过:@Primary /@Qualifier /@Resource 来解决当注入的类有多个Bean时
     */
//注入User
//   2.通过@Qualifier 解决当注入的类有多个Bean时
//   指定当前要注入的Bean的名称,@Qualifier必须要搭配@Autowired使用
//    @Qualifier("UserInfo")
//    @Autowired
//    private User user;

//    3.通过@Resource 解决当注入的类有多个Bean时
////   指定当前要注入的Bean的名称,相较于@Autowired通过类型注入,@Resource是通过Bean的名成注入的,支持更多的参数类型
    @Resource(name = "user1")
    private User user;


    public void say(){
        System.out.println(user);
        userService.say();
        System.out.println("hi,user  Controller...");
    }
}
