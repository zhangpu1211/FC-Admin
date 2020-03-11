package org.fcadmin.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SysMenuParam {
    private Integer id;
    @NotNull
    private String parentId;
    @NotNull
    private String url;
    @NotNull
    private String name;
    private String component;
    private String redirect;
    @NotNull
    private String resources;
    @NotNull
    private Integer menuType;
    @NotNull
    private Integer level;
    private Integer sort;
    private String icon;
    private String remarks;
    @NotNull
    private Boolean isRoute;
    private Boolean keepAlive;
    @NotNull
    private Boolean hidden;
    @NotNull
    private Boolean internalOrExternal;

}
