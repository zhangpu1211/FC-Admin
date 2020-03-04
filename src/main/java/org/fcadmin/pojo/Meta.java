package org.fcadmin.pojo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Meta {
    /**
     * 是否缓存该页面:    1:是   0:不是
     */
    private Boolean keepAlive;

    /**
     * 是否隐藏路由: 0否,1是
     */
    private Integer hidden;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源图标
     */
    private String icon;
}
