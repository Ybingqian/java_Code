package com.springblog.model;

import com.springblog.enums.ResultStatus;
import lombok.Data;

@Data
public class Result {
    private ResultStatus code;//业务码
    private  String errMsg;//错误信息
    private Object data;//接口相应的数据

    public static Result success(Object data){
        Result result=new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static Result nologin(String message){
        Result result=new Result();
        result.setCode(ResultStatus.NOLOGIN);
        result.setErrMsg(message);
        result.setData("");
        return result;
    }

    public static Result fail(String message){
        Result result=new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(message);
        result.setData("");
        return result;
    }

    public static Result fail(String message,Object data){
        Result result=new Result();
        result.setCode(ResultStatus.FAIL);
        result.setErrMsg(message);
        result.setData(data);
        return result;
    }

}
