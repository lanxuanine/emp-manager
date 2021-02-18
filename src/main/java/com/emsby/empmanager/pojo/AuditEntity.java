package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 审核表实体类
 */
@TableName("audit")
public class AuditEntity implements Serializable {
    @TableId(value = "aid")
    private String aid;     //审核表实体类中的唯一标识
    private String aUthor;  //审核的人
    private String aRefer;  //提交审核的人
    private String aRes;  //审核的结果
    @TableField(value = "ar_time")
    private Date createTime;    //提交审核的时间
    private Date aTime;     //审核的时间
    private String aCont;   //审核的内容
    private String aType;  //审核类型
    private String aStat; //审核状态
    private String empid;

    @Override
    public String toString() {
        return "AuditEntity{" +
                "aid='" + aid + '\'' +
                ", aUthor='" + aUthor + '\'' +
                ", aRefer='" + aRefer + '\'' +
                ", aRes='" + aRes + '\'' +
                ", createTime=" + createTime +
                ", aTime=" + aTime +
                ", aCont='" + aCont + '\'' +
                ", aType='" + aType + '\'' +
                ", aStat='" + aStat + '\'' +
                ", empid='" + empid + '\'' +
                ", aAnother='" + aAnother + '\'' +
                '}';
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    private String aAnother;

    public String getaAnother() {
        return aAnother;
    }

    public void setaAnother(String aAnother) {
        this.aAnother = aAnother;
    }

    public AuditEntity() {
    }


    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getaUthor() {
        return aUthor;
    }

    public void setaUthor(String aUthor) {
        this.aUthor = aUthor;
    }

    public String getaRefer() {
        return aRefer;
    }

    public void setaRefer(String aRefer) {
        this.aRefer = aRefer;
    }

    public String getaRes() {
        return aRes;
    }

    public void setaRes(String aRes) {
        this.aRes = aRes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getaTime() {
        return aTime;
    }

    public void setaTime(Date aTime) {
        this.aTime = aTime;
    }

    public String getaCont() {
        return aCont;
    }

    public void setaCont(String aCont) {
        this.aCont = aCont;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public String getaStat() {
        return aStat;
    }

    public void setaStat(String aStat) {
        this.aStat = aStat;
    }
}
