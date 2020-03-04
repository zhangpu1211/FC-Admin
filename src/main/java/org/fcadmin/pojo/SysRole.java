package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_role")
public class SysRole {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 角色英文名称
     */
    private String name;

    /**
     * 角色中文名称
     */
    @Column(name = "name_zh")
    private String nameZh;

    /**
     * 角色描述
     */
    private String remarks;

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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色英文名称
     *
     * @return name - 角色英文名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色英文名称
     *
     * @param name 角色英文名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色中文名称
     *
     * @return name_zh - 角色中文名称
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * 设置角色中文名称
     *
     * @param nameZh 角色中文名称
     */
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    /**
     * 获取角色描述
     *
     * @return remarks - 角色描述
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置角色描述
     *
     * @param remarks 角色描述
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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