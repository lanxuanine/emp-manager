package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 基础的工资信息
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("salary_base")
public class SalaryBaseEntity implements Serializable {
    @TableId
    private String sbid;
    private String wage;
    private String wageOther;
    private String wageType;
    private Timestamp createTime;
    private Timestamp updateTime;
}
