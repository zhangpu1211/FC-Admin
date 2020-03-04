package org.fcadmin.service;

import org.fcadmin.dto.output.SysUserVO;
import org.fcadmin.mapper.SysRoleMapper;
import org.fcadmin.mapper.SysUserMapper;
import org.fcadmin.mapper.SysUserRoleMapper;
import org.fcadmin.pojo.SysRole;
import org.fcadmin.pojo.SysUser;
import org.fcadmin.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

@Service
public class SysUserService  implements UserDetailsService {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /***
     * 根据账号获取用户信息
     * @param username:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        SysUser user = userMapper.selectOneByExample(example);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在!");
        }
        List<SysRole> roles = getUserRoles(user.getId());
        SysUserVO sysUserVO = new SysUserVO(user,roles);
        return sysUserVO;
    }
    /**
     * 根据用户id获取角色权限信息
     *
     * @param userId
     * @return
     */
    private List<SysRole> getUserRoles(Integer userId) {
        Example urexample = new Example(SysUserRole.class);
        Example.Criteria urcriteria = urexample.createCriteria();
        urcriteria.andEqualTo("uid",userId);
        List<SysUserRole> userRoles = userRoleMapper.selectByExample(urexample);
        List<SysRole> roleList = new LinkedList<>();
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleMapper.selectByPrimaryKey(userRole.getRid());
            roleList.add(role);
        }
        return roleList;
    }
}
