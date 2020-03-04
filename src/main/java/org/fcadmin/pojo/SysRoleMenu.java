package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 角色ID
     */
    private Integer rid;

    /**
     * 菜单ID
     */
    private Integer mid;

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
     * 获取角色ID
     *
     * @return rid - 角色ID
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 设置角色ID
     *
     * @param rid 角色ID
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * 获取菜单ID
     *
     * @return mid - 菜单ID
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置菜单ID
     *
     * @param mid 菜单ID
     */
    public void setMid(Integer mid) {
        this.mid = mid;
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