package com.springmvc.controller;

import com.springmvc.model.MessageInfo;
import com.springmvc.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class messageWallController {
    //留言集合:
//     List<MessageInfo> messageInfos=new ArrayList<>();
     @Autowired
    private MessageService messageService;
    /**
     *发表留言
     * @param messageInfo
     * @return
     */
    @RequestMapping("/publish")
    public Boolean publish(MessageInfo messageInfo){
//        1.数据校验
        if(!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())){
            return false;
        }
//        messageInfos.add(messageInfo);
        int n= messageService.insert(messageInfo);
       if(n>0){
           return true;
       }else{
           return false;
       }
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/getAll")
    public List<MessageInfo> getList(){
        return messageService.select();
    }

}
