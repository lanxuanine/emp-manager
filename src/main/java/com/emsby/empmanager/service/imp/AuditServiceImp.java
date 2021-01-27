package com.emsby.empmanager.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emsby.empmanager.mapper.AuditMapper;
import com.emsby.empmanager.pojo.AuditEntity;
import com.emsby.empmanager.service.AuditService;

/**
 * 审核表的service实现层
 */
public class AuditServiceImp extends ServiceImpl<AuditMapper, AuditEntity> implements AuditService {
}
