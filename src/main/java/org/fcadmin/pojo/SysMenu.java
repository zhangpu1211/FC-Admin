package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_menu")
public class SysMenu {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 上级资源ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * url
     */
    private String url;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 组件
     */
    private String component;

    /**
     * 一级菜单跳转地址
     */
    private String redirect;

    /**
     * 资源编码
     */
    private String resources;

    /**
     * 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    @Column(name = "menu_type")
    private Integer menuType;

    /**
     * 资源级别
     */
    private Integer level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否路由菜单: 0:不是  1:是（默认值1）
     */
    @Column(name = "is_route")
    private Boolean isRoute;

    /**
     * 是否叶子节点:    1:是   0:不是
     */
    @Column(name = "is_leaf")
    private Boolean isLeaf;

    /**
     * 是否缓存该页面:    1:是   0:不是
     */
    @Column(name = "keep_alive")
    private Boolean keepAlive;

    /**
     * 是否隐藏路由: 0否,1是
     */
    private Integer hidden;

    /**
     * 外链菜单打开方式 0/内部打开 1/外部打开
     */
    @Column(name = "internal_or_external")
    private Boolean internalOrExternal;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取上级资源ID
     *
     * @return parent_id - 上级资源ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级资源ID
     *
     * @param parentId 上级资源ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取组件
     *
     * @return component - 组件
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件
     *
     * @param component 组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取一级菜单跳转地址
     *
     * @return redirect - 一级菜单跳转地址
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置一级菜单跳转地址
     *
     * @param redirect 一级菜单跳转地址
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * 获取资源编码
     *
     * @return resources - 资源编码
     */
    public String getResources() {
        return resources;
    }

    /**
     * 设置资源编码
     *
     * @param resources 资源编码
     */
    public void setResources(String resources) {
        this.resources = resources;
    }

    /**
     * 获取菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     *
     * @return menu_type - 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     *
     * @param menuType 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取资源级别
     *
     * @return level - 资源级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置资源级别
     *
     * @param level 资源级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取资源图标
     *
     * @return icon - 资源图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置资源图标
     *
     * @param icon 资源图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取是否路由菜单: 0:不是  1:是（默认值1）
     *
     * @return is_route - 是否路由菜单: 0:不是  1:是（默认值1）
     */
    public Boolean getIsRoute() {
        return isRoute;
    }

    /**
     * 设置是否路由菜单: 0:不是  1:是（默认值1）
     *
     * @param isRoute 是否路由菜单: 0:不是  1:是（默认值1）
     */
    public void setIsRoute(Boolean isRoute) {
        this.isRoute = isRoute;
    }

    /**
     * 获取是否叶子节点:    1:是   0:不是
     *
     * @return is_leaf - 是否叶子节点:    1:是   0:不是
     */
    public Boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否叶子节点:    1:是   0:不是
     *
     * @param isLeaf 是否叶子节点:    1:是   0:不是
     */
    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取是否缓存该页面:    1:是   0:不是
     *
     * @return keep_alive - 是否缓存该页面:    1:是   0:不是
     */
    public Boolean getKeepAlive() {
        return keepAlive;
    }

    /**
     * 设置是否缓存该页面:    1:是   0:不是
     *
     * @param keepAlive 是否缓存该页面:    1:是   0:不是
     */
    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    /**
     * 获取是否隐藏路由: 0否,1是
     *
     * @return hidden - 是否隐藏路由: 0否,1是
     */
    public Integer getHidden() {
        return hidden;
    }

    /**
     * 设置是否隐藏路由: 0否,1是
     *
     * @param hidden 是否隐藏路由: 0否,1是
     */
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    /**
     * 获取外链菜单打开方式 0/内部打开 1/外部打开
     *
     * @return internal_or_external - 外链菜单打开方式 0/内部打开 1/外部打开
     */
    public Boolean getInternalOrExternal() {
        return internalOrExternal;
    }

    /**
     * 设置外链菜单打开方式 0/内部打开 1/外部打开
     *
     * @param internalOrExternal 外链菜单打开方式 0/内部打开 1/外部打开
     */
    public void setInternalOrExternal(Boolean internalOrExternal) {
        this.internalOrExternal = internalOrExternal;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}