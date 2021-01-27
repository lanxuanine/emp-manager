package com.emsby.empmanager.pojo;

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
    @TableId
    private String eid;
    private String eJobNum;
    private String eName;
    private String eSex;
    private Date eBarithday;
    private Date eFirstTime;
    private String ePhone;
    private String eAdress;
    private String eMail;
    private String eStat;
    private String eJobTitle;
}
