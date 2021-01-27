package com.emsby.empmanager.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 该项目的工具类
 */
public class EmpManagerTools {
    /*生成随机的唯一的ID标识*/
    public static String enconding(){
        return UUID.randomUUID().toString().replace("-","");
    }
    /*获取到当前的时间转化成数据库的日期*/
    public static Date dateNow(){
        return Date.valueOf(LocalDateTime.now().toLocalDate());
    }
    /*获取当前时间转化成数据的时间*/
    public static Timestamp dateTimeNow(){return Timestamp.valueOf(LocalDateTime.now());}
}
