package com.emsby.empmanager.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 薪资实体类
 */
@Data
public class SalaryEntity implements Serializable {
    @TableId
    private String sid;
    private String sBasePay;
    private String sEtraPay;
    private String sEatPay;
    private String sAcPay;
    private String sDmPay;
}
