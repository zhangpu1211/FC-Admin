package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Oplog {
    @Id
    private Integer id;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    @Column(name = "sys_user_id")
    private Integer sysUserId;

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
     * 获取操作内容
     *
     * @return operate - 操作内容
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 设置操作内容
     *
     * @param operate 操作内容
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }

    /**
     * 获取操作员ID
     *
     * @return sys_user_id - 操作员ID
     */
    public Integer getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置操作员ID
     *
     * @param sysUserId 操作员ID
     */
    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
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