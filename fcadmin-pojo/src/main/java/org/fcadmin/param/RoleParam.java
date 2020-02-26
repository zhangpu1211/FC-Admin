package org.fcadmin.param;

import lombok.Data;

import javax.persistence.Column;
@Data
public class RoleParam {
    private Integer id;

    private String name;

    private String nameZh;
}
