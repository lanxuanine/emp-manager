package com.emsby.empmanager;


import com.emsby.empmanager.mapper.AuditMapper;
import com.emsby.empmanager.mapper.EmpMapper;
import com.emsby.empmanager.pojo.AuditEntity;
import com.emsby.empmanager.pojo.BultEntity;
import com.emsby.empmanager.pojo.EmpEntity;
import com.emsby.empmanager.util.EmpManagerTools;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class EmpManagerApplicationTests {
    @Resource
    private AuditMapper auditMapper;
    @Resource
    private EmpMapper empMapper;
    @Test
    void contextLoads() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").length());
    }
    @Test
    void testInsertAudit(){
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setAid(EmpManagerTools.enconding());
        auditEntity.setaCont("dkjdjid");
        auditEntity.setaRefer("kdjkd");
        auditEntity.setaRes("dkjkg");
        auditEntity.setCreateTime(EmpManagerTools.dateNow());
        auditMapper.insert(auditEntity);
    }
    @Test
    void testFormatDateToSqlDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = Date.valueOf(LocalDateTime.now().toLocalDate());
        Timestamp timestamp1 = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp1);
        System.out.println(date1);
    }
    @Test
    void testInsertEmp(){
        EmpEntity empEntity = new EmpEntity();
        empEntity.setEid(EmpManagerTools.enconding());
        empEntity.setEName("wuhu");
        empMapper.insert(empEntity);
    }

}
