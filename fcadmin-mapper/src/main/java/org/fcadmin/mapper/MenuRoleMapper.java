package org.fcadmin.mapper;

import org.fcadmin.my.mapper.MyMapper;
import org.fcadmin.pojo.MenuRole;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRoleMapper extends MyMapper<MenuRole> {
    Integer insertRecord(Integer rid, Integer[] mids);
}