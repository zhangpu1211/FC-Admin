package org.fcadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fcadmin.pojo.SysLog;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.service.SysLogService;
import org.fcadmin.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"系统日志接口"})
@RequestMapping("/system/log")
public class SysLogController {
    @Autowired
    SysLogService sysLogService;
    @GetMapping("/list")
    @ApiOperation(value = "获取日志信息分页列表", httpMethod = "GET")
    public RespPageBean getUserList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, SysLog sysLog){
        return sysLogService.getLogList(page,size,sysLog);
    }
}
