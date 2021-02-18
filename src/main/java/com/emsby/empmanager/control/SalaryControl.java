package com.emsby.empmanager.control;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emsby.empmanager.mapper.SalaryMapper;
import com.emsby.empmanager.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工工资的管理
 */
@Controller
public class SalaryControl {
    @Resource
    private SalaryService salaryService;

    @RequestMapping("/salary.html")
    public String salaryList(Model model, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "2") Integer pageSize){
        Page page = new Page(pageNum,pageSize);
        List<Map<String, Object>> empd = salaryService.selectEmpSalaryEnd(page);
        for(int j=0;j<empd.size();j++) {
            String eid = empd.get(j).get("empid").toString();
            Map<String,Object> map1 = new HashMap<>();
            List<Map<String,Object>> mapList = salaryService.selectEmpSalaryBase(eid);
            for (int i = 0; i < mapList.size(); i++) {
                if(eid.isEmpty()) {
                    continue;
                };
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
                    case "学历补贴": map1.put("qita", mapList.get(i).get("pay")); break;

                }
                map1.put("ename",mapList.get(i).get("e_name"));
            }
            empd.get(j).putAll(map1);
        }
        model.addAttribute("list",empd);
        model.addAttribute("page",page);
        return "salary-list";
    }

    private Page InitPage(Integer pageNum,Page page){
        int total = (int) page.getTotal();
        return null;
    }
}
