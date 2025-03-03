package com.springcaptcha.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="captcha")
public class YmlComponent {
    private Integer width;
    private Integer height;
    private MySession session;

//    静态内部类
    @Data
    public static class MySession{
        private String key;
        private String time;
    }
}
