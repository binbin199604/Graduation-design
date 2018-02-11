package org.renthouse.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private Integer publishId;

    private Integer toUserId;

    private String content;

    private Integer authenticity;

    private Integer environment;

    private Integer service;

    private Date createTime;

    private Date updateTime;

    public Comment(Integer id, Integer publishId, Integer toUserId, String content, Integer authenticity, Integer environment, Integer service, Date createTime, Date updateTime) {
        this.id = id;
        this.publishId = publishId;
        this.toUserId = toUserId;
        this.content = content;
        this.authenticity = authenticity;
        this.environment = environment;
        this.service = service;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getAuthenticity() {
        return authenticity;
    }

    public void setAuthenticity(Integer authenticity) {
        this.authenticity = authenticity;
    }

    public Integer getEnvironment() {
        return environment;
    }

    public void setEnvironment(Integer environment) {
        this.environment = environment;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
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
}