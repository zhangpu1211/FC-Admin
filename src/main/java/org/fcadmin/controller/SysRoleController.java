package org.fcadmin.controller;

import org.fcadmin.dto.input.SysRoleParam;
import org.fcadmin.pojo.SysRole;
import org.fcadmin.service.SysRoleMenuService;
import org.fcadmin.service.SysRoleService;
import org.fcadmin.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/role")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @GetMapping("/list")
    public List<SysRole> getAllRoles() {
        return sysRoleService.getAllRoles();
    }
    @PutMapping("/save")
    public RespBean updateRole(@RequestBody SysRoleParam sysRoleParam) {
        if (sysRoleService.updateRole(sysRoleParam) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/save")
    public RespBean addRole(@RequestBody  SysRoleParam sysRoleParam) {
        System.out.println(sysRoleParam.toString());
        if (sysRoleService.addRole(sysRoleParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/delete/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (sysRoleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    // 角色更新权限

    @GetMapping("/mids/{rid}")
    public List<Integer> getMenuIdsByRid(@PathVariable Integer rid) {
        return sysRoleMenuService.getMenuIdsByRid(rid);
    }

    @PutMapping("/crole")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (sysRoleMenuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
