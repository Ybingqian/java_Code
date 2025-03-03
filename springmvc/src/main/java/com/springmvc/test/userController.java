package com.springmvc.test;

import com.springmvc.model.user;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@RestController
public class userController {
    @RequestMapping("/test01")
    public String test01(String s){
        return "单个参数:"+s;
    }
  @RequestMapping("/test02")
    public String test02(int n){
        return "单个参数:"+n;
    }
    @RequestMapping("/test03")
    public String test03(Integer n,String s){
        return "多个参数:n:"+n+" s:"+s;
    }
    @RequestMapping("/test04")
    public String test04(user users){
        return "对象为: "+users;
    }
//    前后端参数不一致,参数重命名
    @RequestMapping("/test05")
    public String test05(@RequestParam("time")String createtime){
        return "createtime: "+createtime;
    }
    //    前后端参数不一致,参数重命名,设为非必传参数
    @RequestMapping("/test06")
    public String test06(@RequestParam(value="time",required=false)String createtime){
        return "createtime: "+createtime;
    }
    //传递数组
    @RequestMapping("/test07")
    public String test07(String[] array){
        return "数组为: "+Arrays.toString(array);
    }
//    传递集合
    @RequestMapping("/test08")
//    集合参数需要使用RequestParam注解 修饰
    public String test08(@RequestParam List<String> list){
        return "size= "+list.size()+" list: "+list;
    }
//发送JSON请求
    @RequestMapping("/test09")
    public String test09(@RequestBody user user){
        return "json user:"+user;
    }
//    去掉@RequestBody注解时:
    @RequestMapping("/test10")
    public String test10(user user){
        return "json user:"+user;
    }
//    获取URL中的参数
    @RequestMapping("/test11/{id}/{name}")
    public String test11(@PathVariable Integer id,@PathVariable("name") String userName){
        return "url: id:"+id+" name:"+userName;
    }
//上传文件
    @RequestMapping("/test12")
    public String test12(@RequestPart("file") MultipartFile file) throws IOException {
//      获取文件名
        String name = file.getOriginalFilename();
        //上传文件到指定路径
        file.transferTo(new File("D:/temp/" + file.getOriginalFilename()));
        return "接收到⽂件名称为: "+name;

    }

//    @RequestMapping("/resign")
//    public String resign(String name,Integer age){
//        return "user resign";
//    }


}
