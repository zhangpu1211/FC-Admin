package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Department {
    @Id
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "dep_path")
    private String depPath;

    private Boolean enabled;

    @Column(name = "is_parent")
    private Boolean isParent;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "delete_time")
    private Date deleteTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return dep_path
     */
    public String getDepPath() {
        return depPath;
    }

    /**
     * @param depPath
     */
    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return is_parent
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * @param isParent
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return delete_time
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}