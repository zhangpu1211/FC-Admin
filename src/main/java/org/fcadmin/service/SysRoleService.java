package org.fcadmin.service;

import org.fcadmin.dto.input.SysRoleParam;
import org.fcadmin.mapper.SysRoleMapper;
import org.fcadmin.pojo.SysRole;
import org.fcadmin.utils.BeanValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    public List<SysRole> getAllRoles() {
        return sysRoleMapper.selectAll();
    }

    public int deleteRoleById(Integer rid) {
        return sysRoleMapper.deleteByPrimaryKey(rid);
    }

    public int addRole(SysRoleParam sysRoleParam) {
        BeanValidator.check(sysRoleParam);
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleParam, sysRole);
        return sysRoleMapper.insertSelective(sysRole);
    }


    public int updateRole(SysRoleParam sysRoleParam) {
        BeanValidator.check(sysRoleParam);
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleParam, sysRole);
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }
}
