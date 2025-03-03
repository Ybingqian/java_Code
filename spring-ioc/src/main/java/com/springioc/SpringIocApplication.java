package com.springioc;


import com.springioc.component.UserComponent;
import com.springioc.configuration.UserConfiguration;
import com.springioc.controller.UserController;
import com.springioc.model.User;
import com.springioc.repository.UserRepository;
import com.springioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan注解没有显式配置时，实际上已经包含在了启动类声明注解,默认扫描的范围是SpringBoot启动类所在包及其⼦包
//@ComponentScan()注解:设置Spring的扫描路径
//@ComponentScan("com.springioc")
//1.@ComponentScan的参数为字符串数组,可以传多个路径
//@ComponentScan({"com.springioc.component","com.springioc.service"})
//2.添加@ComponentScan注解,默认会扫描所在包下的所有配置类
//3.推荐把启动类放到希望扫描的包下,就能进行默认扫描了

@SpringBootApplication
public class SpringIocApplication {
    public static void main1(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
//        通过类型获取bean
        UserController bean = context.getBean(UserController.class);
//        通过bean名 和类型获取bean
        UserController bean1 = context.getBean("userController", UserController.class);
//        通过bean名获取bean
        UserController bean2 = (UserController)context.getBean("userController");
        bean.say();
        System.out.println(bean);
        bean1.say();
        System.out.println(bean1);
        bean2.say();
        System.out.println(bean2);
    }
    public static void main2(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        //使用Service获取bean
        UserService bean = (UserService)context.getBean("userService");
        bean.say();
    }
    public static void main3(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        //通过Bean名获取bean
        UserRepository bean = (UserRepository)context.getBean("userRepository");
        bean.say();
    }
    public static void main4(String[] args) {
        //获取spring上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        //通过Bean名获取bean
        UserComponent bean = (UserComponent)context.getBean("userComponent");
        bean.say();
    }
    public static void main5(String[] args) {
        //获取spring上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        //通过Bean名获取bean
        UserConfiguration bean = (UserConfiguration)context.getBean("userConfiguration");
        bean.say();
    }
//    通过bean注解,存储bean,获取bean
    public static void main6(String[] args) {
        //获取spring上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
//        //通过类型获取bean,
//        当同一个类型有多个对象时,根据类型无法获取到bean
//        User bean = context.getBean(User.class);
//        System.out.println(bean);
//        根据名称获取bean,可以获取到bean
        User bean2 = (User)context.getBean("user1");
        User bean3 = (User)context.getBean("USER2");
        System.out.println(bean2);
        System.out.println(bean3);
//通过bean的重命名获取bean
        User bean4 = (User)context.getBean("u3");
        System.out.println("bean重命名获取: "+bean4);
    }

    /**
     * 依赖注入
     * 通过方法注解 @Bean注入,要搭配5大注解使用,名称为方法名
     * @param args
     */
    public static void main7(String[] args) {
        //获取spring上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
//        1.通过属性注入
        UserController bean = context.getBean(UserController.class);
        bean.say();
    }
    public static void main(String[] args) {
        //获取spring上下文
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
//
    }

}
