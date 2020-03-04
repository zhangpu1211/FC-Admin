package org.fcadmin.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_log")
public class SysLog {
    /**
     * 主键ID
     */
    @Id
    private Integer id;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 访问人IP
     */
    private String ip;

    /**
     * 访问人ID 0:未登录用户操作
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 访问状态
     */
    private Integer status;

    /**
     * 接口执行时间
     */
    @Column(name = "execute_time")
    private String executeTime;

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
     * 获取接口名称
     *
     * @return name - 接口名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置接口名称
     *
     * @param name 接口名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取接口地址
     *
     * @return url - 接口地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置接口地址
     *
     * @param url 接口地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取访问人IP
     *
     * @return ip - 访问人IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置访问人IP
     *
     * @param ip 访问人IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取访问人ID 0:未登录用户操作
     *
     * @return user_id - 访问人ID 0:未登录用户操作
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置访问人ID 0:未登录用户操作
     *
     * @param userId 访问人ID 0:未登录用户操作
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取访问状态
     *
     * @return status - 访问状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置访问状态
     *
     * @param status 访问状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取接口执行时间
     *
     * @return execute_time - 接口执行时间
     */
    public String getExecuteTime() {
        return executeTime;
    }

    /**
     * 设置接口执行时间
     *
     * @param executeTime 接口执行时间
     */
    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
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