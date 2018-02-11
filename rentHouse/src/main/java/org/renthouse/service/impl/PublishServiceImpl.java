package org.renthouse.service.impl;

import com.github.pagehelper.PageInfo;
import org.renthouse.common.ResponseCode;
import org.renthouse.common.ServerResponse;
import org.renthouse.dao.HouseOrderMapper;
import org.renthouse.dao.PublishMapper;
import org.renthouse.dao.UserMapper;
import org.renthouse.pojo.HouseOrder;
import org.renthouse.pojo.Publish;
import org.renthouse.pojo.User;
import org.renthouse.service.PublishService;
import org.renthouse.util.DateTimeUtil;
import org.renthouse.vo.HouseOrderBeforeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>PublishServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@Service("publishService")
public class PublishServiceImpl implements PublishService{
    @Autowired
    private PublishMapper publishMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HouseOrderMapper houseOrderMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    public ServerResponse<Publish> selectByPrimaryKey(Integer publishId) {
        return null;
    }

    @Override
    public ServerResponse saveOrUpdatePublishHouse(Publish publish,Integer userId) {
        if(publish != null)
        {
            if(publish.getId() != null){
                publish.setUserId(userId);
                int rowCount = publishMapper.updateByPrimaryKey(publish);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新发布房屋成功");
                }
                return ServerResponse.createBySuccess("更新发布房屋失败");
            }else{
                int rowCount = publishMapper.insert(publish);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增发布房屋成功");
                }
                return ServerResponse.createBySuccess("新增发布房屋失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新发布房屋参数不正确");

    }

    @Override
    public ServerResponse<PageInfo> getPublishHouseList(Integer ownerId, int pageNum, int pageSize) {
        return null;
    }


    @Override
    public ServerResponse showBeforeHouseOrderInfo(Integer publishId) {
        if(publishId != null){
            Publish publish = publishMapper.selectByPrimaryKey(publishId);
            //计算押金
            publish=calculateDeposit(publish);
            User user = userMapper.selectByPrimaryKey(publish.getUserId());
            HouseOrderBeforeVo houseOrderBeforeVo = new HouseOrderBeforeVo();
            houseOrderBeforeVo.setPublish(publish);
            houseOrderBeforeVo.setUserName(user.getName());
            houseOrderBeforeVo.setPhone(user.getPhone());
            //当前系统时间为开始下订单时间
            Date currentDate = new Date();
            houseOrderBeforeVo.setStartTime(DateTimeUtil.dateToStr(currentDate,DateTimeUtil.HOUSEORDER_FORMAT));
            Integer month = publish.getRentTime();
            houseOrderBeforeVo.setEndTime(DateTimeUtil.dateAddmonth(currentDate,month));
        return ServerResponse.createBySuccess(houseOrderBeforeVo);
        }
        return ServerResponse.createByErrorMessage("参数不正确");
    }

    @Override
    public ServerResponse setStatusPublish(Integer publishId, Integer status) {
            if(publishId ==null||status ==null){
                return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
            }
            Publish publish = new Publish();
            publish.setId(publishId);
            publish.setStatus(status);
            int rowCount = publishMapper.updateByPrimaryKeySelective(publish);
            if(rowCount>0){
                return ServerResponse.createBySuccessMessage("修改发布状态成功");
            }
            return ServerResponse.createByErrorMessage("修改发布状态失败");
    }

    @Override
    public ServerResponse deletePublish(Integer publishId) {
        int result =  publishMapper.deleteByPrimaryKey(publishId);
        if(result > 0){
            return ServerResponse.createBySuccessMessage("发布删除成功");
        }
        return ServerResponse.createByErrorMessage("发布删除失败");
    }

    private static Publish calculateDeposit(Publish publish){
        Integer depositNumber=publish.getDepositNumber();
        Integer payNumber = publish.getPayNumber();
        Long rent = publish.getRent();
        Long cashPledge = new Long(0);
        if(depositNumber >= payNumber){
            cashPledge = rent*depositNumber;
            publish.setCashPledge(cashPledge);
        }
        return publish;
    }

    @Override
    public ServerResponse checkToUserAndHouseOrder(Integer toUserId, Integer publishId) {
        int result = houseOrderMapper.checkToUserAndHouseOrder(toUserId,publishId);
        if(result ==0){
            return ServerResponse.createByErrorMessage("此用户没租过此房子，不能评论");
        }
        return ServerResponse.createByErrorMessage("此用户租过此房子，可以评论");
    }
}
