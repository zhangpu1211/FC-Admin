package org.fcadmin.controller;

import org.fcadmin.dto.input.SysUserParam;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.service.SysUserService;
import org.fcadmin.utils.RespBean;
import org.fcadmin.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @GetMapping("/list")
    public RespPageBean getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, SysUser sysUser){
        return sysUserService.getUserList(page,size,sysUser);
    }
    @PostMapping("/save")
    public RespBean save(@RequestBody SysUserParam sysUserParam) {
        if (sysUserService.add(sysUserParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @PutMapping("/save")
    public RespBean update(@RequestBody SysUserParam sysUserParam) {
        if (sysUserService.update(sysUserParam) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @DeleteMapping("/delete/{id}")
    public RespBean update(@PathVariable Integer id) {
        if(id == 1){
            return RespBean.error("超级管理员不可以删除!");
        }
        if (sysUserService.delete(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
