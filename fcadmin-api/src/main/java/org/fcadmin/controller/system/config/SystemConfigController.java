package org.fcadmin.controller.system.config;

import org.fcadmin.service.MenuService;
import org.fcadmin.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menus")
    public List<MenuVO> getMenusBySysUserId(){
        return menuService.getMenusBySysUserId();
    }
}
