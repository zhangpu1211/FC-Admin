package org.fcadmin.param;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class RoleParam {
    private Integer id;
    @NotNull(message = "角色名称不可以为空")
    private String name;
    @NotNull(message = "角色名称不可以为空")
    private String nameZh;
}
