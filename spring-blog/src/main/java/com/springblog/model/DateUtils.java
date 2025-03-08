package com.springblog.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String format(Date createTime){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//       format() 方法: 将Date类型转换成String类型
        return simpleDateFormat.format(createTime);
//         parse()方法:将String类型转换成Date类型
    }
}
