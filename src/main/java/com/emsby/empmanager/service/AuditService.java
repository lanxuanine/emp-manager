package com.emsby.empmanager.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.emsby.empmanager.pojo.AuditEntity;

import java.util.List;

/**
 * 审核表的service层
 */
public interface AuditService extends IService<AuditEntity> {

    public Page<AuditEntity> aListOAudit(Integer pageNum,Integer pageSize,String...keyWords);

    public boolean aInsertAudit(AuditEntity auditEntity);
}
