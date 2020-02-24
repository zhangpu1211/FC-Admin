package org.fcadmin.mapper;

import org.fcadmin.dto.MenuWithRolesDTO;
import org.fcadmin.my.mapper.MyMapper;
import org.fcadmin.pojo.Menu;
import org.fcadmin.vo.MenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper extends MyMapper<Menu> {

    List<MenuWithRolesDTO> getAllMenusWithRole();

    List<MenuVO> getMenusBySysUserId(Integer id);

    List<MenuVO> getSystemMenus(Integer pid);
    List<Integer> getIdsByPid(Integer pid);
}