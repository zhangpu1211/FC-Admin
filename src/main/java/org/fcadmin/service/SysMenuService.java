package org.fcadmin.service;

import cn.hutool.core.collection.CollUtil;
import org.fcadmin.dto.input.SysMenuParam;
import org.fcadmin.dto.output.SysMenuVO;
import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.mapper.SysMenuMapper;
import org.fcadmin.mapper.SysRoleMenuMapper;
import org.fcadmin.mapper.SysUserMapper;
import org.fcadmin.mapper.SysUserRoleMapper;
import org.fcadmin.pojo.SysMenu;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.utils.BeanValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.security.Principal;
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
//
//    public List<SysMenu> getPidOfZreo(){
//        Example example = new Example(SysMenu.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("parent_id", 0);
//        return sysMenuMapper.selectByExample(example);
//    }

    public List<SysMenuVO> getSystemMenus() {
        return sysMenuMapper.getSystemMenus(0);
    }

    public int addMenu(SysMenuParam sysMenuParam) {
        BeanValidator.check(sysMenuParam);
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuParam, sysMenu);
        // todo 以后可能需要修改
        sysMenu.setRemarks("");
        sysMenu.setIsLeaf(false);
        if(!"0".equals(sysMenu.getParentId())){
            Example example = new Example(SysMenu.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", sysMenu.getParentId());
            SysMenu select = sysMenuMapper.selectOneByExample(example);
            sysMenu.setComponent("/" + select.getResources() + "/" + sysMenu.getResources());
        }
        return sysMenuMapper.insertSelective(sysMenu);
    }

    public int updateMenu(SysMenuParam sysMenuParam) {
        BeanValidator.check(sysMenuParam);
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuParam, sysMenu);
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }
    @Transactional(rollbackFor = Exception.class)
    public int deleteMenu(Integer id) {
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", id);
        List<SysMenu> sysMenus = sysMenuMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(sysMenus)){
            return -1;
        }
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

}

