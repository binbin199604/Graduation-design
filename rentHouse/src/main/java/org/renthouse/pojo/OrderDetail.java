package org.renthouse.pojo;

import java.util.Date;

public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer publishId;

    private Integer userId;

    private Integer toUserId;

    private Date createTime;

    private Date updateTime;

    private Date endTime;

    private Long money;

    private Integer payMonth;

    private Integer leaveMonth;

    private Integer payType;

    public OrderDetail(Integer id, Integer orderId, Integer publishId, Integer userId, Integer toUserId, Date createTime, Date updateTime, Date endTime, Long money, Integer payMonth, Integer leaveMonth, Integer payType) {
        this.id = id;
        this.orderId = orderId;
        this.publishId = publishId;
        this.userId = userId;
        this.toUserId = toUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.endTime = endTime;
        this.money = money;
        this.payMonth = payMonth;
        this.leaveMonth = leaveMonth;
        this.payType = payType;
    }

    public OrderDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(Integer payMonth) {
        this.payMonth = payMonth;
    }

    public Integer getLeaveMonth() {
        return leaveMonth;
    }

    public void setLeaveMonth(Integer leaveMonth) {
        this.leaveMonth = leaveMonth;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}