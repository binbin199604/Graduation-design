package org.renthouse.service.impl;

import org.renthouse.common.ServerResponse;
import org.renthouse.dao.OrderDetailMapper;
import org.renthouse.pojo.OrderDetail;
import org.renthouse.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <dl>
 * <dt>OrderDetailServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class OrderDetailServiceImpl implements OrderDetailService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public ServerResponse saveOrUpdateOrderDetail(OrderDetail orderDetail) {
        if(orderDetail != null)
        {
            if(orderDetail.getId() != null){
                int rowCount = orderDetailMapper.updateByPrimaryKey(orderDetail);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新交易详细成功");
                }
                return ServerResponse.createBySuccess("更新交易详细失败");
            }else{
                int rowCount = orderDetailMapper.insert(orderDetail);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增交易详细成功");
                }
                return ServerResponse.createBySuccess("新增交易详细失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新交易详细参数不正确");
    }
}

