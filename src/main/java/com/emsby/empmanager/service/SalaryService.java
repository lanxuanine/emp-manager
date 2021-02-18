package com.emsby.empmanager.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emsby.empmanager.pojo.SalaryEntity;

import java.util.List;
import java.util.Map;

/**
 * 考勤的service
 */
public interface SalaryService extends IService<SalaryEntity> {
    List<Map<String,Object>> selectEmpSalaryBase(String id);
    List<Map<String,Object>> selectEmpSalaryEnd(Page page);

}
