package org.fcadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fcadmin.dto.input.SysUserParam;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.service.SysUserService;
import org.fcadmin.utils.RespBean;
import org.fcadmin.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/system/user")
@Api(tags={"系统管理员接口"})
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @GetMapping("/userInfo")
    @ApiOperation(value = "获取登陆管理员信息", httpMethod = "GET")
    public SysUser getUserInfo(Principal principal){
        return sysUserService.getUserInfo(principal);
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取管理员信息分页列表", httpMethod = "GET")
    public RespPageBean getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, SysUser sysUser){
        return sysUserService.getUserList(page,size,sysUser);
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增管理员", httpMethod = "POST")
    public RespBean save(@RequestBody SysUserParam sysUserParam) {
        if (sysUserService.add(sysUserParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @PutMapping("/save")
    @ApiOperation(value = "更新管理员信息", httpMethod = "PUT")
    public RespBean update(@RequestBody SysUserParam sysUserParam) {
        if (sysUserService.update(sysUserParam) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除管理员", httpMethod = "DELETE")
    public RespBean update(@PathVariable Integer id) {
        if(id == 1){
            return RespBean.error("超级管理员不可以删除!");
        }
        if (sysUserService.delete(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/userRole")
    @ApiOperation(value = "更新管理员所属角色", httpMethod = "PUT")
    public RespBean updateUserRole(Integer uid, Integer[] rids) {
        if (sysUserService.updateUserRole(uid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
