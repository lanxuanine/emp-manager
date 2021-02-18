package com.emsby.empmanager.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emsby.empmanager.mapper.AuditMapper;
import com.emsby.empmanager.pojo.AuditEntity;
import com.emsby.empmanager.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Queue;

/**
 * 审核表的service实现层
 */
@Service
public class AuditServiceImp extends ServiceImpl<AuditMapper, AuditEntity> implements AuditService {
    @Autowired
    private AuditMapper auditMapper;
    public Page<AuditEntity> aListOAudit(Integer pageNum,Integer pageSize,String...keyWords){
        QueryWrapper<AuditEntity> auditEntityQueryWrapper = new QueryWrapper<>();
        Page<AuditEntity> page = new Page<>(pageNum, pageSize);
        return auditMapper.selectPage(page,auditEntityQueryWrapper);
    }

    public boolean aInsertAudit(AuditEntity auditEntity){
        if (auditEntity != null) new Exception("auditEntity该对象是空的或不符合规范，不可以添加!");
       return auditMapper.insert(auditEntity) >0;
    }
}
