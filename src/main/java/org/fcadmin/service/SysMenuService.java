package org.fcadmin.service;

import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.dto.output.SysUserVO;
import org.fcadmin.mapper.SysMenuMapper;
import org.fcadmin.mapper.SysRoleMenuMapper;
import org.fcadmin.mapper.SysUserMapper;
import org.fcadmin.mapper.SysUserRoleMapper;
import org.fcadmin.pojo.SysMenu;
import org.fcadmin.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Service
public class SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    SysUserMapper sysUserMapper;

    //根据用户id来生成对应权限菜单
    public List<SideBarMenuVO> getSideBarMenu(Principal principal) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",principal.getName());
        SysUser sysUser = sysUserMapper.selectOneByExample(example);
        return sysMenuMapper.getMenusBySysUserId(sysUser.getId());
    }

    public List<SysMenu> getPidOfZreo(){
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parent_id", 0);
        return sysMenuMapper.selectByExample(example);
    }

}

