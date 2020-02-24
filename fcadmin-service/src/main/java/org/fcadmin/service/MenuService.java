package org.fcadmin.service;

import org.fcadmin.dto.MenuWithRolesDTO;
import org.fcadmin.mapper.MenuMapper;
import org.fcadmin.param.MenuParam;
import org.fcadmin.pojo.Menu;
import org.fcadmin.utils.BeanValidator;
import org.fcadmin.vo.MenuVO;
import org.fcadmin.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
//    获取所有菜单，用于权限选择
//    public List<MenuVO> getAllMenus(){
//        return menuMapper.getAllMenus();
//    }
    //用户发起请求时校验是否拥有权限
    public List<MenuWithRolesDTO> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
    //根据用户id来生成对应权限菜单
    public List<MenuVO> getMenusBySysUserId() {
        return menuMapper.getMenusBySysUserId(((SysUserVO)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<MenuVO> getSystemMenus() {
        return menuMapper.getSystemMenus(0);
    }

    public int addMenu(MenuParam menuParam) {
        BeanValidator.check(menuParam);
        Menu menu = Menu.builder().name(menuParam.getName()).url(menuParam.getUrl()).component(menuParam.getComponent())
                .path(menuParam.getPath()).iconCls(menuParam.getIconCls()).sort(menuParam.getSort())
                .enabled(true).parentId(menuParam.getParentId()).requireAuth(true).build();
        return menuMapper.insertSelective(menu);
    }

    public int updateMenu(MenuParam menuParam) {
        BeanValidator.check(menuParam);
        Menu menu = Menu.builder().id(menuParam.getId()).name(menuParam.getName()).url(menuParam.getUrl()).component(menuParam.getComponent())
                .path(menuParam.getPath()).iconCls(menuParam.getIconCls()).sort(menuParam.getSort())
                .enabled(true).parentId(menuParam.getParentId()).requireAuth(true).build();
        return menuMapper.updateByPrimaryKeySelective(menu);
    }
    @Transactional(rollbackFor = Exception.class)
    public int deleteMenu(Integer id) {
        List<Integer> ids = menuMapper.getIdsByPid(id);
        if(ids!=null && !ids.isEmpty()){
            return -1;
        }
        return menuMapper.deleteByPrimaryKey(id);
    }
}
