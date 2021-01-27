package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 考勤实体类
 */
@TableName("clockin")
public class ClockinEntity implements Serializable {
    @TableId
    private String cid;
    private String clockStat;
    private String absence;
    private String earlyTime;
    private String onTime;
    private String workTime;
    private String restTime;
    private String laterTime;

    @Override
    public String toString() {
        return "ClockinEntity{" +
                "cid='" + cid + '\'' +
                ", clockStat='" + clockStat + '\'' +
                ", absence='" + absence + '\'' +
                ", earlyTime='" + earlyTime + '\'' +
                ", onTime='" + onTime + '\'' +
                ", workTime='" + workTime + '\'' +
                ", restTime='" + restTime + '\'' +
                ", laterTime='" + laterTime + '\'' +
                '}';
    }

    public ClockinEntity() {
        super();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getClockStat() {
        return clockStat;
    }

    public void setClockStat(String clockStat) {
        this.clockStat = clockStat;
    }

    public String getAbsence() {
        return absence;
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public String getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(String earlyTime) {
        this.earlyTime = earlyTime;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getLaterTime() {
        return laterTime;
    }

    public void setLaterTime(String laterTime) {
        this.laterTime = laterTime;
    }
}
