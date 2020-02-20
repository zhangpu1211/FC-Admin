package org.fcadmin.service;

import org.fcadmin.dto.MenuWithRolesDTO;
import org.fcadmin.mapper.MenuMapper;
import org.fcadmin.pojo.Menu;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.vo.MenuVO;
import org.fcadmin.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    //获取所有菜单，用于权限选择
    public List<MenuVO> getAllMenus(){
        return menuMapper.getAllMenus();
    }
    //用户发起请求时校验是否拥有权限
    public List<MenuWithRolesDTO> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
    //根据用户id来生成对应权限菜单
    public List<MenuVO> getMenusBySysUserId() {
        return menuMapper.getMenusBySysUserId(((SysUserVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
