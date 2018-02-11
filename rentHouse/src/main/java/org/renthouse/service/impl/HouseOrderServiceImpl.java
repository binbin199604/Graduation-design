package org.renthouse.service.impl;

import org.renthouse.common.ServerResponse;
import org.renthouse.dao.HouseOrderMapper;
import org.renthouse.pojo.HouseOrder;
import org.renthouse.service.HouseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <dl>
 * <dt>HouseOrderServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class HouseOrderServiceImpl implements HouseOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseOrderMapper houseOrderMapper;

    @Override
    public ServerResponse saveOrUpdateHouseOrder(HouseOrder houseOrder) {
        if(houseOrder != null)
        {
            if(houseOrder.getId() != null){
                int rowCount = houseOrderMapper.updateByPrimaryKey(houseOrder);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新出租订单成功");
                }
                return ServerResponse.createBySuccess("更新出租订单失败");
            }else{
                int rowCount = houseOrderMapper.insert(houseOrder);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增出租订单成功");
                }
                return ServerResponse.createBySuccess("新增出租订单失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新出租订单参数不正确");

    }




}
