package org.fcadmin.controller.system.basic;

import org.fcadmin.param.RoleParam;
import org.fcadmin.pojo.Role;
import org.fcadmin.service.MenuService;
import org.fcadmin.service.RoleService;
import org.fcadmin.utils.RespBean;
import org.fcadmin.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/role")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMenuIdsByRid(@PathVariable Integer rid) {
        return menuService.getMenuIdsByRid(rid);
    }

    @PutMapping("/role")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (roleService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody RoleParam role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
