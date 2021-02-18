package com.emsby.empmanager.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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
    /*将object封装成map类型数据*/
    public static List<Map<String,Object>> ListObjectToMap(Object bean) throws Exception {
        if (bean == null) throw new Exception("传入的值为空，反生错误");
        if (bean instanceof List){
            Iterator<?> iterator =  ((List<?>) bean).iterator();
            List<Map<String,Object>> map = new ArrayList<>();
            Map<String, Object> map1 = new HashMap<>();
            while(iterator.hasNext()){
                Class bc = iterator.next().getClass();
                Field[] fields = bc.getDeclaredFields();
                Object obc = iterator.next();
                for(Field fil : fields){
                    fil.setAccessible(true);
                    map1.put(fil.getName(),fil.get(obc));
                }
                map.add(map1);
            }
            return  map;
        }else {
            throw new Exception("传入的值不是集合类型的");
        }
    }
    public static Map<String,Object> ObjectToMap(Object bean) throws Exception {
        if (bean == null) throw new Exception("传入的值为空，反生错误");
        Class obj = bean.getClass();
        Field[] fields = obj.getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        Object obj1 = bean;
        for (Field fi : fields) {
            fi.setAccessible(true);
            String fieldName = fi.getName();
            map.put(fieldName, fi.get(obj1));
        }
        return map;
    }

}
