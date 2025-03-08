package com.springblog.mapper;

import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class JwtUtilsTest {

//  设置过期时长 毫秒:1小时
    private static final long Expiration=60*60*1000;
//      密钥
    private static final String secretString = "dYSgwUxEtcTEjNHKAZ11S1Bgyj5IwOtyh26UyDcNNg/oYRu0GvsNQPlC7q78qmH5";
//    生成安全密钥
    public static SecretKey KEY= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
//      生成令牌
    @Test
    public void getJwt(){
        Map<String,Object> claim=new HashMap<>();
        claim.put("id",1);
        claim.put("name","zhangsan");
        String jwt = Jwts.builder()
                .setClaims(claim)//自定义内容
                .setIssuedAt(new Date())//设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + Expiration))//设置过期时间
                .signWith(KEY)//签名算法
                .compact();
        System.out.println(jwt);
    }
//  生成 密钥（对 长度和内容 有要求)
    @Test
    public void getKey(){
//        使用Keys.secretKeyFor方法 创建 密钥
        Key key=Keys.secretKeyFor(SignatureAlgorithm.HS384);
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(secretString);
    }
//    校验令牌  根据令牌,根据令牌的合法性
//    解析过程中,没有报错,令牌就是合法的,就会返回 载荷信息(自己往Map中填入的信息)
    @Test
    public void parseJwt(){
//        token就是令牌
        String token="eyJhbGciOiJIUzM4NCJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6MSwiaWF0IjoxNzQxMTgxNDI2LCJleHAiOjE3NDExODUwMjZ9.pcT5zjbAK3ZCokQOkFbjLWxC6pT6WUdLHJxqop-HFUIMNaADm-_Q5uTiFOCsmuUC";
//       创建解析器,设置签名密钥
        JwtParserBuilder jwtParserBuilder=Jwts.parserBuilder().setSigningKey(KEY);
//      解析token
        Claims claims = jwtParserBuilder.build().parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
//    通过令牌完成用户的登录
}
