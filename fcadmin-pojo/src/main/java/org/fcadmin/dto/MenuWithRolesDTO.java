package org.fcadmin.dto;

import lombok.Data;
import org.fcadmin.pojo.Menu;
import org.fcadmin.pojo.Role;

import java.util.List;
@Data
public class MenuWithRolesDTO {
    private Integer id;
    private String url;
    private String name;
    private List<Role> roles;
}
