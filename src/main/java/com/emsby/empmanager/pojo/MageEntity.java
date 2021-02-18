package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 管理者/登录用户表实体类
 */
@Data
@TableName("mage")
public class MageEntity implements Serializable {
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private Timestamp createTime;
}
