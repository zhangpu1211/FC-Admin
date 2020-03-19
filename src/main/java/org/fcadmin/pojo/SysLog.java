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
    private String method;

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
    private String uname;

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


    public String getUrl() {
        return url;
    }

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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