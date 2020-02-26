package org.fcadmin.service;

import org.fcadmin.mapper.MenuRoleMapper;
import org.fcadmin.mapper.RoleMapper;
import org.fcadmin.param.RoleParam;
import org.fcadmin.pojo.MenuRole;
import org.fcadmin.pojo.Role;
import org.fcadmin.utils.BeanValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.selectAll();
    }

    public int addRole(RoleParam roleParam) {
        BeanValidator.check(roleParam);
        Role role = new Role();
        BeanUtils.copyProperties(roleParam, role);
        return roleMapper.insertSelective(role);
    }

    public int deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
    //更新资源角色表
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        //更新资源角色表
        Example example = new Example(MenuRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("rid", rid);
        menuRoleMapper.deleteByExample(example);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
