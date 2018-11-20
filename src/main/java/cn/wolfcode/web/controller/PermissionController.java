package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Permission;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) {
        model.addAttribute("pageResult", permissionService.query(qo));
        return "permission/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        permissionService.delete(id);
        //当权限删除的时候(权限与角色)关系删除
        permissionService.deletePermissonRole(id);
        return "redirect:/permission/list";
    }
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (id != null) {
            model.addAttribute("permission", permissionService.get(id));
        }
        return "permission/input";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Permission entry) {
        if (entry.getId() != null) {
            permissionService.update(entry);
        } else {
            permissionService.save(entry);
        }
        return "redirect:/permission/list";
    }

    @RequestMapping("/onload")
    public ModelAndView permissionOnload(){
        permissionService.onload();
        return null;
    }
}
