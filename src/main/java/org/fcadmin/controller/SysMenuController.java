package org.fcadmin.controller;

import cn.hutool.core.collection.CollUtil;
import org.fcadmin.dto.input.SysMenuParam;
import org.fcadmin.dto.output.SysMenuVO;
import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.service.SysMenuService;
import org.fcadmin.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/sidebar")
    public RespBean getSideBarMenu(Principal principal){
        List<SideBarMenuVO> barMenuVO = sysMenuService.getSideBarMenu(principal);
        List<String> resources = new ArrayList<>();
        for (SideBarMenuVO menuVO : barMenuVO){
            resources.add(menuVO.getResources());
            if(CollUtil.isNotEmpty(menuVO.getChildren())){
                List<SideBarMenuVO> childs = menuVO.getChildren();
                for (SideBarMenuVO child : childs) {
                    resources.add(child.getResources());
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("sidebar", barMenuVO);
        map.put("resources", resources);
        return RespBean.ok(null, map);
    }

    /**
     * 常规操作
     */
    //获取所有权限
    @GetMapping("/list")
    public List<SysMenuVO> getSystemMenus(){
        return sysMenuService.getSystemMenus();
    }
    //新增权限
    @PostMapping("/save")
    public RespBean addSystemMenus(@RequestBody SysMenuParam sysMenuParam){
        if (sysMenuService.addMenu(sysMenuParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    //删除权限
    @DeleteMapping("/delete/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        Integer res = sysMenuService.deleteMenu(id);
        if (res == 1) {
            return RespBean.ok("删除成功!");
        }else if (res == -1){
            return RespBean.error("请先删除该权限下的子权限");
        }
        return RespBean.error("删除失败!");
    }

    //修改权限
    @PutMapping("/save")
    public RespBean updateSystemMenus(@RequestBody SysMenuParam sysMenuParam){
        if (sysMenuService.updateMenu(sysMenuParam) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }
}
