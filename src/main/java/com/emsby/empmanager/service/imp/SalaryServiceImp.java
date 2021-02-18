package com.emsby.empmanager.service.imp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emsby.empmanager.mapper.SalaryMapper;
import com.emsby.empmanager.pojo.SalaryEntity;
import com.emsby.empmanager.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SalaryServiceImp extends ServiceImpl<SalaryMapper, SalaryEntity> implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Map<String, Object>> selectEmpSalaryBase(String id) {
        return salaryMapper.getEmpPay(id);
    }

    @Override
    public List<Map<String, Object>> selectEmpSalaryEnd(Page page) {
        return salaryMapper.getEmpDep(page);
    }
}
