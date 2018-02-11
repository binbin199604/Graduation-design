package org.renthouse.vo;

import org.renthouse.pojo.Publish;

/**
 * <dl>
 * <dt>HouseOrderBeforeVo</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class HouseOrderBeforeVo {
    private Publish publish;
    private String userName;
    private String phone;
    //显示给前端的时间，并不是真正支付后出租的时间
    private String startTime;
    private String endTime;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}