package org.renthouse.service;

import com.github.pagehelper.PageInfo;
import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.Publish;

import java.util.List;
import java.util.Map;

public interface PublishService {

    ServerResponse<Publish> selectByPrimaryKey(Integer publishId);

    ServerResponse saveOrUpdatePublishHouse(Publish publish,Integer userId);

    ServerResponse<PageInfo> getPublishHouseList(Integer ownerId,int pageNum, int pageSize);

    //显示生成订单前，给租客的概要信息
    ServerResponse showBeforeHouseOrderInfo(Integer publishId);

    //修改发布状态
    ServerResponse setStatusPublish(Integer publishId,Integer status);

    //删除发布
    ServerResponse deletePublish (Integer publishId);

    //检查用户是否为租客，有对应的下订单表
    ServerResponse checkToUserAndHouseOrder(Integer toUserId,Integer publishId);
}
