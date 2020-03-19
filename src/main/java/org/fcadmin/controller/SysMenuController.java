package org.fcadmin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fcadmin.dto.input.SysMenuParam;
import org.fcadmin.dto.output.SysMenuVO;
import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.service.SysMenuService;
import org.fcadmin.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/menu")
@Api(tags={"系统菜单接口"})
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/sidebar")
    @ApiOperation(value = "根据用户获取对应侧边栏", httpMethod = "GET")
    public RespBean getSideBarMenu(Principal principal){
        List<SideBarMenuVO> barMenuVO = sysMenuService.getSideBarMenu(principal);
        // todo 修改按钮权限
        List<String> menuResource = sysMenuService.getMenusResource(principal);
        Map<String, Object> map = new HashMap<>();
        map.put("sidebar", barMenuVO);
        map.put("resources", menuResource);
        return RespBean.ok(null, map);
    }

    /**
     * 常规操作
     */
    //获取所有权限
    @GetMapping("/list")
    @ApiOperation(value = "获取所有权限", httpMethod = "GET")
    public List<SysMenuVO> getSystemMenus(){
        return sysMenuService.getSystemMenus();
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增菜单", httpMethod = "POST")
    public RespBean addSystemMenus(@RequestBody SysMenuParam sysMenuParam){
        if (sysMenuService.addMenu(sysMenuParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除菜单", httpMethod = "DELETE")
    public RespBean deleteHrById(@PathVariable Integer id) {
        Integer res = sysMenuService.deleteMenu(id);
        if (res == 1) {
            return RespBean.ok("删除成功!");
        }else if (res == -1){
            return RespBean.error("请先删除该权限下的子权限");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/save")
    @ApiOperation(value = "更新菜单", httpMethod = "PUT")
    public RespBean updateSystemMenus(@RequestBody SysMenuParam sysMenuParam){
        if (sysMenuService.updateMenu(sysMenuParam) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }
}
