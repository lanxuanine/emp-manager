package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 员工的实体类
 */
@TableName("emp")
@Data
public class EmpEntity implements Serializable {
    @TableId(value = "eid",type = IdType.NONE)
    private String eid;
    private String eJobNum;
    private String eName;
    private String eSex;
    private Date eBarithday;
    private Date eJoinTime;
    private String ePhone;
    private String eAdress;
    private String eMail;
    private String eStat;
    private String eJobTitle;
    private String eRole;   //员工角色
    private String eDucaback;
    private String eDucType;
}
