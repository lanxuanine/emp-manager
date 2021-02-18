package com.emsby.empmanager.control;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.emsby.empmanager.service.AuditService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 审核的控制类
 */
@Controller
public class AuditControl {
    @Resource
    private AuditService auditService;
    private final String thisView= "audit-list";


    @RequestMapping("/audit.do")
    public String getAuditList(Model model, @RequestParam(required = false,defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(required = false,defaultValue = "2",value = "pageSize") Integer pageSize, String...keyWords){
        try {
            model.addAttribute("audits", auditService.aListOAudit(pageNum,pageSize,keyWords));
        }catch(Exception e){
            e.printStackTrace();
        }
        return thisView;
    }
}
