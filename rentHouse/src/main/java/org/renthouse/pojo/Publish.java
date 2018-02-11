package org.renthouse.pojo;

import java.util.Date;

public class Publish {
    private Integer id;

    private Integer houseId;

    private Integer userId;

    private String title;

    private Integer payNumber;

    private Integer depositNumber;

    private Long rent;

    private Long cashPledge;

    private Date createTime;

    private Date updateTime;

    private Date publishTime;

    private String rentWay;

    private Integer rentTime;

    private Integer status;

    private Integer visit;

    public Publish(Integer id, Integer houseId, Integer userId, String title, Integer payNumber, Integer depositNumber, Long rent, Long cashPledge, Date createTime, Date updateTime, Date publishTime, String rentWay, Integer rentTime, Integer status, Integer visit) {
        this.id = id;
        this.houseId = houseId;
        this.userId = userId;
        this.title = title;
        this.payNumber = payNumber;
        this.depositNumber = depositNumber;
        this.rent = rent;
        this.cashPledge = cashPledge;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.publishTime = publishTime;
        this.rentWay = rentWay;
        this.rentTime = rentTime;
        this.status = status;
        this.visit = visit;
    }

    public Publish() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(Integer payNumber) {
        this.payNumber = payNumber;
    }

    public Integer getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(Integer depositNumber) {
        this.depositNumber = depositNumber;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Long getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(Long cashPledge) {
        this.cashPledge = cashPledge;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getRentWay() {
        return rentWay;
    }

    public void setRentWay(String rentWay) {
        this.rentWay = rentWay == null ? null : rentWay.trim();
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public void setRentTime(Integer rentTime) {
        this.rentTime = rentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }
}