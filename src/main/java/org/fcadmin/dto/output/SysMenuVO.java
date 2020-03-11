package org.fcadmin.dto.output;

import lombok.Data;

import java.util.List;

@Data
public class SysMenuVO {
    private Integer id;
    private String parentId;
    private String url;
    private String name;
    private String component;
    private String redirect;
    private String resources;
    private Integer menuType;
    private Integer level;
    private Integer sort;
    private String icon;
    private String remarks;
    private Boolean isRoute;
    private Boolean isLeaf;
    private Boolean keepAlive;
    private Boolean hidden;
    private Boolean internalOrExternal;
    private List<SysMenuVO> children;
}
