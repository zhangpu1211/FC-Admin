package org.fcadmin.mapper;

import org.fcadmin.my.mapper.MyMapper;
import org.fcadmin.pojo.Role;
import org.fcadmin.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysUserMapper extends MyMapper<SysUser> {
    SysUser loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer id);
}