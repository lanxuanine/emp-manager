package com.emsby.empmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emsby.empmanager.pojo.SalaryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 考勤mapper
 */
public interface SalaryMapper extends BaseMapper<SalaryEntity> {
    //获取员工基本固定的工资
    List<Map<String,Object>> getEmpPay(@Param("id")String id);
    //获取员工最后的工资和部门信息
    List<Map<String,Object>> getEmpDep(Page page);
}
