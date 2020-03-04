package org.fcadmin.config.security;

import org.fcadmin.mapper.SysMenuMapper;
import org.fcadmin.mapper.SysRoleMapper;
import org.fcadmin.mapper.SysRoleMenuMapper;
import org.fcadmin.pojo.SysMenu;
import org.fcadmin.pojo.SysRole;
import org.fcadmin.pojo.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    SysMenuMapper menuMapper;
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //功能核心 根据请求地址分析所需角色
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println(requestUrl);

        List<SysMenu> permissionList = menuMapper.selectAll();
        for (SysMenu permiss : permissionList) {
            if(permiss.getUrl() == null || permiss.getUrl().length() == 0){
                continue;
            }
            if(antPathMatcher.match(permiss.getUrl(),requestUrl)){
                Example example = new Example(SysRoleMenu.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("mid", permiss.getId());
                List<SysRoleMenu> permissions = sysRoleMenuMapper.selectByExample(example);
                List<String> roles = new LinkedList<>();

                if (!CollectionUtils.isEmpty(permissions)){
                    permissions.forEach( e -> {
                        Integer rid = e.getRid();
                        SysRole role = sysRoleMapper.selectByPrimaryKey(rid);
                        roles.add(role.getName());
                    });
                }
                return SecurityConfig.createList(roles.toArray(new String[roles.size()]));
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
