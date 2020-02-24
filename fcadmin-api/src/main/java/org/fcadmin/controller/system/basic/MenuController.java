package org.fcadmin.controller.system.basic;

import org.fcadmin.param.MenuParam;
import org.fcadmin.pojo.Menu;
import org.fcadmin.service.MenuService;
import org.fcadmin.utils.RespBean;
import org.fcadmin.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//权限管理
@RestController
@RequestMapping("/system/menu/")
public class MenuController {
    @Autowired
    MenuService menuService;
    //获取所有权限
    @GetMapping("/sysMenus")
    public List<MenuVO> getSystemMenus(){
        return menuService.getSystemMenus();
    }
    //新增权限
    @PostMapping("/sysMenus")
    public RespBean addSystemMenus(@RequestBody MenuParam menuParam){
        if (menuService.addMenu(menuParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    //删除权限
    @DeleteMapping("/sysMenus/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        Integer res = menuService.deleteMenu(id);
        if (res == 1) {
            return RespBean.ok("删除成功!");
        }else if (res == -1){
            return RespBean.error("请先删除该权限下的子权限");
        }
        return RespBean.error("删除失败!");
    }

    //修改权限
    @PutMapping("/sysMenus")
    public RespBean updateSystemMenus(@RequestBody MenuParam menuParam){
        if (menuService.updateMenu(menuParam) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
}
