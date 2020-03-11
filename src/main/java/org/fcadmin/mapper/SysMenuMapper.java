package org.fcadmin.mapper;

import org.fcadmin.config.mapper.MyMapper;
import org.fcadmin.dto.output.SysMenuVO;
import org.fcadmin.dto.output.SideBarMenuVO;
import org.fcadmin.pojo.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper extends MyMapper<SysMenu> {
    List<SideBarMenuVO> getMenusBySysUserId(Integer uid);

    List<SysMenuVO> getSystemMenus(int i);
}