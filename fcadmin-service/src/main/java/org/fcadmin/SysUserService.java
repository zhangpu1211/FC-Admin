package org.fcadmin;

import org.fcadmin.mapper.RoleMapper;
import org.fcadmin.mapper.SysUserMapper;
import org.fcadmin.mapper.SysUserRoleMapper;
import org.fcadmin.pojo.Role;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysUserService implements UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在!");
        }
        List<Role> roles = sysUserMapper.getUserRolesByUid(user.getId());
        SysUserVO sysUserVO = new SysUserVO(user,roles);
        return sysUserVO;
    }
}
