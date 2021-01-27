package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 公告表
 */
@Table("bult")
public class BultEntity implements Serializable {
    @TableId
    private String bid;
    private String bText;
    private Timestamp bTime;
    private String bAuthor;
    private String bStatus;

    public BultEntity() {
        super();
    }

    @Override
    public String toString() {
        return "BultEntity{" +
                "bid='" + bid + '\'' +
                ", bText='" + bText + '\'' +
                ", bTime=" + bTime +
                ", bAuthor='" + bAuthor + '\'' +
                ", bStatus='" + bStatus + '\'' +
                '}';
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getbText() {
        return bText;
    }

    public void setbText(String bText) {
        this.bText = bText;
    }

    public Timestamp getbTime() {
        return bTime;
    }

    public void setbTime(Timestamp bTime) {
        this.bTime = bTime;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbStatus() {
        return bStatus;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }
}
