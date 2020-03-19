package org.fcadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags={"系统角色接口"})
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @GetMapping("/list")
    @ApiOperation(value = "获取所有角色-未分页", httpMethod = "GET")
    public List<SysRole> getAllRoles() {
        return sysRoleService.getAllRoles();
    }


    @PutMapping("/save")
    @ApiOperation(value = "更新角色信息", httpMethod = "PUT")
    public RespBean updateRole(@RequestBody SysRoleParam sysRoleParam) {
        if (sysRoleService.updateRole(sysRoleParam) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增角色", httpMethod = "POST")
    public RespBean addRole(@RequestBody  SysRoleParam sysRoleParam) {
        System.out.println(sysRoleParam.toString());
        if (sysRoleService.addRole(sysRoleParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/delete/{rid}")
    @ApiOperation(value = "删除角色", httpMethod = "DELETE")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (sysRoleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    // 角色更新权限

    @GetMapping("/mids/{rid}")
    @ApiOperation(value = "根据角色ID查询所属菜单", httpMethod = "GET")
    public List<Integer> getMenuIdsByRid(@PathVariable Integer rid) {
        return sysRoleMenuService.getMenuIdsByRid(rid);
    }

    @PutMapping("/crole")
    @ApiOperation(value = "根据角色ID更新所属菜单", httpMethod = "PUT")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (sysRoleMenuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
