package org.fcadmin.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class SysRoleParam {
    private Integer id;
    @NotNull(message = "角色名称不可以为空")
    private String name;
    @NotNull(message = "角色名称不可以为空")
    private String nameZh;
}
