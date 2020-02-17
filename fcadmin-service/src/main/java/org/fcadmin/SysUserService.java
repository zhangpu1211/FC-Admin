package org.fcadmin;

import org.fcadmin.mapper.SysUserMapper;
import org.fcadmin.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SysUserService implements UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        SysUser user = sysUserMapper.loadUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("账户不存在!");
//        }
//        user.setRoles(sysUserMapper.getUserRolesByUid(user.getId()));
//        return user;
        return null;
    }
}
