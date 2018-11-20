package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Department;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private Environment environment;

    @RequiredPermission("部门列表查询")
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) {
        Environment e = environment;
        model.addAttribute("pageResult", departmentService.query(qo));
        return "department/list";
    }

    @RequiredPermission("部门删除")
    @RequestMapping("/delete")
    public String delete(Long id) {
        departmentService.delete(id);
        return "redirect:/department/list";
    }
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (id != null) {
            //查询回显数据
            model.addAttribute("department", departmentService.get(id));
        }
        return "department/input";
    }

    @RequiredPermission("部门保存或删除")
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department entry) {
        if (entry.getId() != null) {
            departmentService.update(entry);
        } else {
            departmentService.save(entry);
        }
        return "redirect:/department/list";
    }
}
