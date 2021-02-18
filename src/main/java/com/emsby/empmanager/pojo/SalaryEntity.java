package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * 薪资实体类
 */
@Data
@TableName("salary")
public class SalaryEntity implements Serializable {
    @TableId("sid")
    private String sid;
    private String sDmPay;
    private String sWagePay;    //应付工资
    private String sNetPay;
    private String sYearPay;
    private String sDarkMoney;
    private String sPit;
    private String sFsiaohs;
    private Date createTime;
    private String empid;
}
