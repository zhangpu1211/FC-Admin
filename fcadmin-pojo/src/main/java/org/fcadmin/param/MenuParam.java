package org.fcadmin.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class MenuParam {
    private Integer id;
    @NotNull
    private String url;
    @NotNull
    private String path;
    @NotNull
    private String component;
    @NotNull
    private String name;
    private String iconCls;
    @NotNull
    private Integer sort;
    @NotNull
    private Integer parentId;
}
