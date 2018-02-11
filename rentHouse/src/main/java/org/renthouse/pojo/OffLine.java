package org.renthouse.pojo;

import java.util.Date;

public class OffLine {
    private Integer id;

    private Integer userId;

    private Integer toUserId;

    private Date createTime;

    private Date updateTime;

    private Date appointTime;

    private String time;

    private Integer personNumber;

    private String toUserPhone;

    private Integer status;

    private Integer publishId;

    public OffLine(Integer id, Integer userId, Integer toUserId, Date createTime, Date updateTime, Date appointTime, String time, Integer personNumber, String toUserPhone, Integer status, Integer publishId) {
        this.id = id;
        this.userId = userId;
        this.toUserId = toUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.appointTime = appointTime;
        this.time = time;
        this.personNumber = personNumber;
        this.toUserPhone = toUserPhone;
        this.status = status;
        this.publishId = publishId;
    }

    public OffLine() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public String getToUserPhone() {
        return toUserPhone;
    }

    public void setToUserPhone(String toUserPhone) {
        this.toUserPhone = toUserPhone == null ? null : toUserPhone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }
}