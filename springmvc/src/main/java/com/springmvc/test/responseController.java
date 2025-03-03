package com.springmvc.test;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

//@RestController
@Controller
@RequestMapping("/resp")
public class responseController {
    @RequestMapping("/test01")
    public String getIndex(){
        return "/index.html";
    }
    @ResponseBody
    @RequestMapping("/test02")
     public String getIndex02(){
        return "index页面";
     }
     @ResponseBody
    @RequestMapping("/test03")
     public String getHtml(){
        return "<h1>你好</h1>";
     }
     @ResponseBody
     @RequestMapping("/test04")
     public HashMap<String,String> getJson(){
        HashMap<String,String> map=new HashMap<>();
        map.put("001","zhangsan");
        map.put("002","lisi");
        map.put("003","wangwu");
        return map;
     }
     @ResponseBody
     @RequestMapping("/test05")
     public String setStstus(HttpServletResponse response){
        response.setStatus(400);
        return "状态码设置成功";
     }
    @ResponseBody
     @RequestMapping(value = "/test06",produces = "application/json")
     public String setContentType(){
        return "{success:1}";
     }
     @ResponseBody
     @RequestMapping(value = "/test07")
     public String setContentType02(){
        return "{success:1}";
     }
     @ResponseBody
     @RequestMapping("/test08")
     public String setHeader(HttpServletResponse response){
        response.setStatus(500);
        return "设置响应状态成功";
     }
}
