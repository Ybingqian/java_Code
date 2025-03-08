package com.springblog.model;


import com.springblog.constant.BlogConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建JWT工具
 */
@Slf4j
public class JwtUtils {
//    密钥:
    private static String secret= "dYSgwUxEtcTEjNHKAZ11S1Bgyj5IwOtyh26UyDcNNg/oYRu0GvsNQPlC7q78qmH5";
//  过期时间:毫秒 1小时
    private static long Expiration= 60*60*1000;
//    生成安全密钥
    private static SecretKey secretKey= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
//    生成令牌
    public static String genTwt(Map<String,Object> claim){
        String jwt = Jwts.builder()
                .setClaims(claim) //自定义载荷
                .setIssuedAt(new Date())//设置签发时间
                .setExpiration(new Date(System.currentTimeMillis()+ Expiration))//设置过期时间
                .signWith(secretKey)//签名算法
                .compact();
        return jwt;
    }
//    验证密钥
    public static Claims parseJWT(String jwt){
        //1.数据校验
        if(!StringUtils.hasLength(jwt)){
            return null;
        }
        JwtParserBuilder jwtParserBuilder = Jwts.parserBuilder().setSigningKey(secretKey);
        Claims claims=null;
        try{
//            解析token
            claims = jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
        }catch(Exception e){
//            签名验证失败
            log.error("解析令牌错误.jwt:",jwt);
        }
        return claims;
    }

    /**
//    从Token中获取 用户id
     *
     * @param JwtToken  JWT令牌
     * @return  返回用户Id
     */
    public static Integer getUserIdByToken(String JwtToken){
//        对令牌进行解密
        Claims claims=JwtUtils.parseJWT(JwtToken);
        log.info("解析token: claims: {}",claims);
//        校验
        if(claims!=null){
            Map<String,Object> map = new HashMap<>(claims);
            return (Integer)map.get(BlogConstants.TOKEN_ID);
        }
        log.error("JetUtils: 从header中获取id失败!");
        return null;
    }

}
