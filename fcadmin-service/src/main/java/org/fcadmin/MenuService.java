package org.fcadmin;

import org.fcadmin.mapper.MenuMapper;
import org.fcadmin.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenus(){
        return null;
        //return menuMapper.getAllMenus();
    }
}
