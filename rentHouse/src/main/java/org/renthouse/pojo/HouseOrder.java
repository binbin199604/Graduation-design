package org.renthouse.pojo;

import java.util.Date;

public class HouseOrder {
    private Integer id;

    private Integer houseId;

    private Integer publishId;

    private Integer userId;

    private Integer toUserId;

    private Date createTime;

    private Date updateTime;

    private Date endTime;

    private Integer monthLimit;

    private Integer status;

    public HouseOrder(Integer id, Integer houseId, Integer publishId, Integer userId, Integer toUserId, Date createTime, Date updateTime, Date endTime, Integer monthLimit, Integer status) {
        this.id = id;
        this.houseId = houseId;
        this.publishId = publishId;
        this.userId = userId;
        this.toUserId = toUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.endTime = endTime;
        this.monthLimit = monthLimit;
        this.status = status;
    }

    public HouseOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(Integer monthLimit) {
        this.monthLimit = monthLimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}