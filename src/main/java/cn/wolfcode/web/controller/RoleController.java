package cn.wolfcode.web.controller;

import cn.wolfcode.domain.Role;
import cn.wolfcode.query.QueryObject;
import cn.wolfcode.service.IDepartmentService;
import cn.wolfcode.service.IPermissionService;
import cn.wolfcode.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) {
        model.addAttribute("pageResult", roleService.query(qo));
        return "role/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        roleService.delete(id);

        //当角色删除的时候删除(角色与权限)的关系
        roleService.deleteRolePermission(id);
        //当角色删除的时候删除(角色与员工)的关系
        roleService.deleteRoleEmployee(id);
        return "redirect:/role/list";
    }

    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (id != null) {
            model.addAttribute("role", roleService.get(id));
        }

        //在类表中回显permission权限
        model.addAttribute("permissions", permissionService.listAll());
        return "role/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role entry, Long[] permissionIds) {
        if (entry.getId() != null) {
            roleService.update(entry);

            //删除原来角色对应的权限
            roleService.deleteRolePermission(entry.getId());
        } else {
            roleService.save(entry);
        }
        //重新角色增加权限
        if (permissionIds != null) {
            for (Long permissionId : permissionIds) {
                roleService.insertRolePermission(permissionId, entry.getId());
            }
        }
        return "redirect:/role/list";
    }
}
