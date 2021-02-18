package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 考勤实体类
 */
@TableName("clockin")
@Data
public class ClockinEntity implements Serializable {
    @TableId
    private String cid;
    private String clockStat;
    private String absence;
    private String earlyTime;
    private String onStauts;
    private String workTime;
    private String restTime;
    private String laterTime;
    private String overTime;
    private String empid;  //员工的id
    private Timestamp updateTime;

}
