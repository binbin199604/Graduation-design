package org.renthouse.vo;

/**
 * <dl>
 * <dt>OrderVo</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class OrderVo {
    private Integer orderId;
    private Integer publishId;
    private Integer userId;
    private Integer toUserId;
    private String title;
    private String userName;
    private String toUserName;
    private double rent;
    private double cashPledge;
    private Integer payWay;
    //真正支付后出租的时间
    private String startTime;
    //租金交多少月后的时间
    private String rentEndTime;
    //限制的时间
    private String endTime;
}
