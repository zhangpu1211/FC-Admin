package org.fcadmin.dto.output;

import lombok.Data;
import org.fcadmin.pojo.Meta;

import java.util.List;
@Data
public class SideBarMenuVO {
    private Integer id;
    /**
     * 资源编码
     */
    private String resources;
    private String parentId;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 一级菜单跳转地址
     */
    private String redirect;
    private String component;
    private Meta meta;
    private Integer sort;
    private List<SideBarMenuVO> children;
}
