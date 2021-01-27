package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 部门的实体类
 */
@TableName("dep")
public class DepEntity implements Serializable {
    @TableId
    private String did;
    private String dNum;
    private String dName;

    @Override
    public String toString() {
        return "DepEntity{" +
                "did='" + did + '\'' +
                ", dNum='" + dNum + '\'' +
                ", dName='" + dName + '\'' +
                '}';
    }

    public DepEntity(String did, String dNum, String dName) {
        this.did = did;
        this.dNum = dNum;
        this.dName = dName;
    }

    public DepEntity() {
        super();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getdNum() {
        return dNum;
    }

    public void setdNum(String dNum) {
        this.dNum = dNum;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
