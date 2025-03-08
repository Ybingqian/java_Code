package com.springblog.model;

import ch.qos.logback.core.util.MD5Util;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 对数据库中的密码进行 MD5加密
 */
public class SecurityUtils {
    /** 对密码进行加密
     * @param password 用户注册时输入的明文密码
     * @return MD5加密后的字符串: salt+MD5(salt+明文密码)
     */
    public static String encrypt(String password){
//        1.生成随机 盐值 (每次生成的内容不同,长度固定为32位)
//        生成的随机盐值是带有"-",将其去除,
        String salt=UUID.randomUUID().toString().replace("-","");
//        System.out.println(UUID.randomUUID().toString().replace("-"," "));
//        2.MD5加密:
//       先将 随机盐值和明文密码拼接:
        String password1=salt+password;
//        进行MD5加密:
        String finalPassword = DigestUtils.md5DigestAsHex(password1.getBytes());
//        将MD5加密后的 密码再和上面生成的随机盐值 拼接,并以最终密码返回:
//        (注意拼接顺序,对用户输入的密码解密时要按照相同方式进行解密)
        return salt+finalPassword;
    }

    /**
     * 解密: 从数据库中保存的密码获取盐值,对用户输入的密码进行MD5加密,
     *      将加密后的结果和数据库中的加密密码进行比较,判断是否一致
     * @param inputPassword 用户登录时输入的密码
     * @param sqlPassword 数据库中保存的加密 密码
     * @return true: 密码正确
     *        false :密码错误
     */
    public static Boolean verify(String inputPassword,String sqlPassword){
//        1.数据校验
        if(!StringUtils.hasLength(inputPassword)){
//            用户输入密码为空
            return false;
        }
        if(sqlPassword.length()!=64){
//       对数据库密码长度校验:salt为32位,MD5加密后的密码为32位,数据库中保存的密码一定都是64位的
            return false;
        }
//        2.从sqlPassword中获取 盐值: 前32位
        String salt=sqlPassword.substring(0,32);
//        3.对用户输入的密码进行MD5加密,
//        (由于加密的盐值就是从数据库中密码中获取的,因此,数据库中密码加码的盐值和现在加密的盐值是同一个)
//        因此,若加密后的结果和数据库中的MD5密码一致,则证明用户输入的密码正确
        String password1=salt+inputPassword;
        String finalPassword=DigestUtils.md5DigestAsHex(password1.getBytes());
//        根据两次加密后的密码是否一致,返回结果
        return (salt+finalPassword).equals(sqlPassword);
    }

    public static void main(String[] args) {
        System.out.println(SecurityUtils.encrypt("123456"));
        System.out.println(SecurityUtils.encrypt("123456"));
        System.out.println(SecurityUtils.encrypt("123456"));
        System.out.println(SecurityUtils.encrypt("123456"));
    }
}
