package org.fcadmin.service;

import org.fcadmin.mapper.SysRoleMenuMapper;
import org.fcadmin.pojo.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleMenuService {
    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

    public List<Integer> getMenuIdsByRid(Integer rid) {
        Example example = new Example(SysRoleMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("rid", rid);
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectByExample(example);
        // todo 获取其中的ids
        List<Integer> ids = sysRoleMenus.stream().map(roleMenu -> roleMenu.getMid()).collect(Collectors.toList());
        return ids;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        //更新资源角色表
        Example example = new Example(SysRoleMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("rid", rid);
        sysRoleMenuMapper.deleteByExample(example);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = sysRoleMenuMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
