package org.fcadmin.config.security;

import org.fcadmin.dto.MenuWithRolesDTO;
import org.fcadmin.pojo.Menu;
import org.fcadmin.pojo.Role;
import org.fcadmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;


import java.util.Collection;
import java.util.List;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //功能核心 根据请求地址分析所需角色
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<MenuWithRolesDTO> allMenus = menuService.getAllMenusWithRole();
        for (MenuWithRolesDTO menuWithRolesDTO:allMenus) {
            if(antPathMatcher.match(menuWithRolesDTO.getUrl(),requestUrl)){
                List<Role> roles = menuWithRolesDTO.getRoles();
                String [] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++){
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        //当所有的请求路径与数据库的均匹配不上，用ROLE_LOGIN作为一个标记符，后续再进行处理
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
