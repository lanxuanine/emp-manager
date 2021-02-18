package com.emsby.empmanager;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emsby.empmanager.mapper.*;
import com.emsby.empmanager.pojo.*;
import com.emsby.empmanager.util.EmpManagerTools;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@SpringBootTest
@MapperScan("com.emsby.empmanager.mapper")
class EmpManagerApplicationTests {
    @Resource
    private AuditMapper auditMapper;
    @Resource
    private EmpMapper empMapper;
    @Autowired
    private SalaryBaseMapper salaryBaseMapper;
    @Autowired
    private DepMapper depMapper;
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SalaryMapper salaryMapper;
    @Resource
    private ClockinMapper clockinMapper;
    @Test
    void contextLoads() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-",""));
    }
    @Test
    void testInsertAudit(){
        QueryWrapper wrapper = new QueryWrapper<>();
        List<EmpEntity> list = empMapper.selectList(wrapper);
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setAid(EmpManagerTools.enconding());
        auditEntity.setaCont("失恋了，心情不好，想出去走走！");
        auditEntity.setaRefer(list.get(4).getEName());
        auditEntity.setaRes("");
        auditEntity.setEmpid(list.get(4).getEid());
        auditEntity.setaUthor(list.get(1).getEName());
        auditEntity.setaType("其他");
        auditEntity.setaStat("2");
        auditEntity.setaAnother("");
        auditEntity.setCreateTime(EmpManagerTools.dateNow());
//        auditEntity.setaTime(Date.valueOf("2021-02-08"));
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
        empEntity.setEName("刘云海");
        empEntity.setESex("男");
        empEntity.setEAdress("北京顺义");
        empEntity.setEBarithday(Date.valueOf("1979-10-17"));
        empEntity.setEJobTitle("项目总经理");
        empEntity.setERole("010");
        empEntity.setEDucaback("本科");
        empEntity.setEDucType("0110");
        empEntity.setEStat("1");
        empEntity.setEJobNum("NO.1009");
        empMapper.insert(empEntity);
    }
    @Test
    void testJavaSqlClass(){
        //测试java自带的sql的时间time类
        Time time = Time.valueOf(LocalTime.now());
        System.out.println(time);
    }
    //向基本的工资信息表插入信息
    @Test
    void testInitSalaryBase(){
        List<String> list = new ArrayList<String>(){ {add("基本工资");add("学历补贴-本科"); add("学历补贴-硕士"); add("学历补贴-博士"); add("餐补");add("全勤奖");add("加班费");add("缺勤扣钱");}};
        List<String> list1 = Arrays.asList("6000","100","200","400","20","500","15","-10");
        List<SalaryBaseEntity>  sblist = new ArrayList<>();
        int i =0;
        for (String sl : list){
            SalaryBaseEntity salaryBaseEntity = new SalaryBaseEntity();
            salaryBaseEntity.setSbid(EmpManagerTools.enconding());
            salaryBaseEntity.setWageType(sl);
            salaryBaseEntity.setWage(list1.get(i++));
            salaryBaseEntity.setCreateTime(EmpManagerTools.dateTimeNow());
            sblist.add(salaryBaseEntity);
        }
        Iterator<SalaryBaseEntity> it = sblist.iterator();
        while(it.hasNext()){
            salaryBaseMapper.insert(it.next());
        }
    }
    //向部门插入数据
    @Test
    void testInitDep(){
        List<String> list = new ArrayList<>();
        list.add("人力资源部");
        list.add("信息部");
        list.add("行政部");
        list.add("财务部");
        list.add("研发部");
        list.add("生产部");
        list.add("采购部");
        list.add("品质部");

        for(String li : list){
            DepEntity depEntity = new DepEntity();
            depEntity.setDid(EmpManagerTools.enconding());
            depEntity.setdName(li);
            depEntity.setdNum(hanyupin(li)+String.valueOf(rander())+(char)('A'+Math.random()*('Z'-'A'+1)));
            depMapper.insert(depEntity);
        }

    }
    //获取汉字拼音首字母
    private String hanyupin(String hanzi){
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<hanzi.length();i++){
            char word = hanzi.charAt(i);
            String[] pinyin= PinyinHelper.toHanyuPinyinStringArray(word);
            if(pinyin!=null){
                sb.append(pinyin[0].charAt(0));
            }else{
                sb.append(word);
            }

        }
        return sb.toString().toUpperCase().replace("B","");
    }
    //随机生成数字
    private Integer rander(){
        Random random = new Random();
        return random.nextInt(999);
    }

    @Test
    void zimu(){
        System.out.println((char)('A'+Math.random()*('Z'-'A'+1)));
    }

    void insetT(){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("eid");
        List<EmpEntity> list = empMapper.selectList(wrapper);
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("wage_type","基本工资");
        wrapper1.select("sbid");
        List<SalaryBaseEntity> list1 = salaryBaseMapper.selectList(wrapper1);
        String sql = "INSERT INTO `emp-salarybase` VALUES(?,?)";
        for(EmpEntity en : list){
            jdbcTemplate.update(sql,list1.size()==1?list1.get(0).getSbid():"",en.getEid());
        }
    }
    @Test
    void testInitClockin(){
            ClockinEntity clockinEntity = new ClockinEntity();
            clockinEntity.setCid(EmpManagerTools.enconding());
            clockinEntity.setWorkTime(String.valueOf((int) (Math.random() * 5 )+17));
            clockinEntity.setUpdateTime(EmpManagerTools.dateTimeNow());
            clockinEntity.setEarlyTime(randomInt());
            clockinEntity.setOverTime(randomInt());
            clockinEntity.setLaterTime(randomInt());
            clockinMapper.insert(clockinEntity);
            clockinEntity = null;
            System.gc();
    }
    @Test
    void testUPCLockin(){
        List<ClockinEntity> clockinEntities = clockinMapper.selectList(new QueryWrapper<>());
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("eid");
        List<EmpEntity> list = empMapper.selectList(wrapper);
        int i = 0;
        for (ClockinEntity cl : clockinEntities){
            cl.setEmpid(list.get(i++).getEid());
            clockinMapper.updateById(cl);
        }
    }
    private String randomInt(){
        return String.valueOf((int)(Math.random()*6));
    }
    @Test
    void testRandomMath(){
        System.out.println(randomInt());
    }

    @Test
    void testSetSalary(){
        List<Map<String,Object>> map = salaryMapper.getEmpPay(null);
        SalaryEntity salaryEntity = new SalaryEntity();
        for(int i =0; i< map.size();i++){
           String n = map.get(i).get("name").toString();
           salaryEntity.setSid(EmpManagerTools.enconding());
           salaryEntity.setSWagePay(map.get(i).get("yinf").toString());
           salaryEntity.setEmpid(String.valueOf(map.get(i).get("dif")));
           salaryMapper.insert(salaryEntity);
        }
    }
    //工资列表方法一
    @Test
    void testSelectSalary() {
        List<Map<String,Object>> mapList = salaryMapper.getEmpPay(null);
        Page page2  = new Page(1,3);
        List<Map<String, Object>> empd = salaryMapper.getEmpDep(page2);
        Page page = new Page(1,2);
        Page<SalaryEntity> page1 = salaryMapper.selectMapsPage(page, null);
        for(int j=0;j<empd.size();j++) {
            String eid = empd.get(j).get("empid").toString();
            Map<String,Object> map1 = new HashMap<>();
            for (int i = 0; i < mapList.size(); i++) {
                if(eid.isEmpty() || !eid.equals(mapList.get(i).get("eid"))) {
                    continue;
                };
                String type = (String) mapList.get(i).get("wage_type");
                switch (type) {
                    case "餐补":
                        map1.put("canbu", mapList.get(i).get("pay"));
                        break;
                    case "基本工资":
                        map1.put("jibg", mapList.get(i).get("pay"));
                        break;
                    case "全勤奖":
                        map1.put("quanj", mapList.get(i).get("pay"));
                        break;
                    default:
                        map1.put("qita", mapList.get(i).get("pay"));
                        map1.put("ename",mapList.get(i).get("e_name"));
                        break;
                }
            }
            empd.get(j).putAll(map1);
        }
        return ;
    }
    //获取工资列表
    @Test
    void testSelectSalary1(){
        List<Map<String, Object>> empd = salaryMapper.getEmpDep(null);
        for(int j=0;j<empd.size();j++) {
            String eid = empd.get(j).get("empid").toString();
            Map<String,Object> map1 = new HashMap<>();
            List<Map<String,Object>> mapList = salaryMapper.getEmpPay(eid);
            for (int i = 0; i < mapList.size(); i++) {
                if(eid.isEmpty()) {
                    continue;
                }
                String type = (String) mapList.get(i).get("wage_type");
                if (type.startsWith("学历补贴-")){
                    type = type.substring(0,type.indexOf("-"));
                }
                switch (type) {
                    case "餐补":
                        map1.put("canbu", mapList.get(i).get("pay"));
                        break;
                    case "基本工资":
                        map1.put("jibg", mapList.get(i).get("pay"));
                        break;
                    case "全勤奖":
                        map1.put("quanj", mapList.get(i).get("pay"));
                        break;
                    default:
                        map1.put("qita", mapList.get(i).get("pay"));
                        map1.put("ename",mapList.get(i).get("e_name"));
                        break;
                }
            }
            empd.get(j).putAll(map1);
        }
        return ;
    }

    private Map<String,Object> ObjectToMap(Object bean) throws IllegalAccessException, InstantiationException {
        if (bean instanceof List){
            Iterator<?> iterator =  ((List<?>) bean).iterator();
            List<Map<String,Object>> map = new ArrayList<>();
            Map<String, Object> map1 = new HashMap<>();
            while(iterator.hasNext()){
                Class bc = iterator.next().getClass();
                Field[] fields = bc.getDeclaredFields();
                Object obc = iterator.next();
                for(Field fil : fields){
                    fil.setAccessible(true);
                    map1.put(fil.getName(),fil.get(obc));
                }
                map.add(map1);
            }
            return  null;
        }else {
            Class obj = bean.getClass();
            Field[] fields = obj.getDeclaredFields();
            Map<String, Object> map = new HashMap<>();
            Object obj1 = bean;
            for (Field fi : fields) {
                fi.setAccessible(true);
                String fieldName = fi.getName();
                map.put(fieldName, fi.get(obj1));
            }
            return map;
        }
    }
    @Test
    void testFanShe() throws Exception{
//        EntityToMap(SalaryEntity.class);
        QueryWrapper<SalaryEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("s_net_pay",14200);
        SalaryEntity salaryEntity = salaryMapper.selectOne(queryWrapper);
        ObjectToMap(salaryEntity);
    }
}
