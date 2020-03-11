package org.fcadmin.mapper;

import org.fcadmin.config.mapper.MyMapper;
import org.fcadmin.pojo.SysRoleMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMenuMapper extends MyMapper<SysRoleMenu> {
    Integer insertRecord(Integer rid, Integer[] mids);
}