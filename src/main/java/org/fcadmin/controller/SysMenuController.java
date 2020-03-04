package org.fcadmin.controller;

import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/sidebar")
    public List<SideBarMenuVO> getSideBarMenu(Principal principal){
        return sysMenuService.getSideBarMenu(principal);
    }
}
