package org.renthouse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import org.renthouse.common.Const;
import org.renthouse.common.ServerResponse;
import org.renthouse.dao.HouseMapper;
import org.renthouse.dao.UserMapper;
import org.renthouse.dao.PublishMapper;
import org.renthouse.pojo.House;
import org.renthouse.pojo.User;
import org.renthouse.pojo.Publish;
import org.renthouse.service.HouseService;
import org.renthouse.vo.HouseDetailVo;
import org.renthouse.vo.HouseListVo;
import org.renthouse.vo.HouseRecommendListVo;
import org.renthouse.vo.HouseSearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("houseService")
public class HouseServiceImpl implements HouseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private PublishMapper publishMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse saveOrUpdateHouse(House house) {
        if(house != null)
        {
//            图片保存
//            if(StringUtils.isNotBlank(product.getSubImages())){
//                String[] subImageArray = product.getSubImages().split(",");
//                if(subImageArray.length > 0){
//                    product.setMainImage(subImageArray[0]);
//                }
//            }

            if(house.getId() != null){
                int rowCount = houseMapper.updateByPrimaryKey(house);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新房屋成功");
                }
                return ServerResponse.createBySuccess("更新房屋失败");
            }else{
                int rowCount = houseMapper.insert(house);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增房屋成功");
                }
                return ServerResponse.createBySuccess("新增房屋失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新房屋参数不正确");
    }



    public ServerResponse<PageInfo> listHouse(String orderBy,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(orderBy)){
            if(Const.HouseListOrderBy.RENT_ASC_DESC.contains(orderBy)||Const.HouseListOrderBy.PUBLISHTIME_ASC_DESC.contains(orderBy)){
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0]+" "+orderByArray[1]);
            }
        }
        List<Map<String,Object>> houseListMap = houseMapper.list();
        System.out.println(houseListMap.size());
        List<HouseListVo> houseListVoList = Lists.newArrayList();
        for(Map<String,Object> houseMapItem : houseListMap){
            HouseListVo houseListVo = assembleHouseListVo(houseMapItem);
            houseListVoList.add(houseListVo);
        }
        PageInfo pageResult = new PageInfo(houseListMap);
        pageResult.setList(houseListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    public ServerResponse<PageInfo> searchHouse(HouseSearchVo houseSearchVo,String keyword,String orderBy,int pageNum, int pageSize){

        if(houseSearchVo==null&&StringUtils.isBlank(keyword)){
            return  this.listHouse(orderBy,pageNum,pageSize);
        }

        if(StringUtils.isNotBlank(keyword)){
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();
        }
        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(orderBy)){
            if(Const.HouseListOrderBy.RENT_ASC_DESC.contains(orderBy)){
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0]+" "+orderByArray[1]);
            }
        }
        List<Map<String,Object>> houseListMap;

            houseListMap = houseMapper.list();

            houseListMap = houseMapper.search(
                    keyword,
                    houseSearchVo.getDistrict(),
                    houseSearchVo.getLowerRent(),
                    houseSearchVo.getUpperRent(),
                    houseSearchVo.getRoom(),
                    houseSearchVo.getWay(),
                    houseSearchVo.getType(),
                    houseSearchVo.getLocation(),
                    houseSearchVo.getElevator(),
                    houseSearchVo.getSubway()
            );

       System.out.println(houseListMap.size());
        List<HouseListVo> houseListVoList = Lists.newArrayList();
        for(Map<String,Object> houseMapItem : houseListMap){
            HouseListVo houseListVo = assembleHouseListVo(houseMapItem);
            houseListVoList.add(houseListVo);
        }
        PageInfo pageResult = new PageInfo(houseListMap);
        pageResult.setList(houseListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    private HouseListVo assembleHouseListVo(Map<String,Object> houseMapItem){
        //根据house信息填进houseVo中
        Integer userId = Integer.parseInt(houseMapItem.get("userId").toString());
        System.out.println("userId="+userId);
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println("user="+user);
        HouseListVo houseListVo = new HouseListVo();
        houseListVo.setUserName(user.getName());
        houseListVo.setUserId(userId);
        houseListVo.setTopFloor(Integer.parseInt(houseMapItem.get("topFloor").toString()));
        houseListVo.setTitle(houseMapItem.get("title").toString());
        houseListVo.setSubwayNumber(houseMapItem.get("subwayNumber").toString());
        houseListVo.setSquare(Integer.parseInt(houseMapItem.get("square").toString()));
        houseListVo.setRoom(Integer.parseInt(houseMapItem.get("room").toString()));
        houseListVo.setRentWay(houseMapItem.get("rentWay").toString());
        houseListVo.setRent(Double.parseDouble(houseMapItem.get("rent").toString()));
        houseListVo.setPublishId(Integer.parseInt(houseMapItem.get("publishId").toString()));
        houseListVo.setLocation(houseMapItem.get("location").toString());
        houseListVo.setHouseId(Integer.parseInt(houseMapItem.get("houseId").toString()));
        houseListVo.setHall(Integer.parseInt(houseMapItem.get("hall").toString()));
        houseListVo.setFloor(Integer.parseInt(houseMapItem.get("floor").toString()));
        houseListVo.setDistrict(houseMapItem.get("district").toString());
        houseListVo.setCommunity(houseMapItem.get("community").toString());
        houseListVo.setStreet(houseMapItem.get("street").toString());
        return houseListVo;
    }

    @Override
    public ServerResponse<HouseDetailVo> selectHouseDetail(Integer publishId) {
        Publish publish = publishMapper.selectByPrimaryKey(publishId);
        House house = houseMapper.selectByPrimaryKey(publish.getHouseId());
        User user = userMapper.selectByPrimaryKey(publish.getUserId());
        //每次访问详细房屋，访客量visit+1
        publish.setVisit(publish.getVisit()+1);
        int row = publishMapper.updateByPrimaryKey(publish);
        if(row <= 0){
            return ServerResponse.createByErrorMessage("增加访客量visit失败");
        }
        HouseDetailVo houseDetailVo = assembleHouseDetailtVo(house,publish,user);
        return ServerResponse.createBySuccess(houseDetailVo);
    }

    private HouseDetailVo assembleHouseDetailtVo(House house,Publish publish,User user){
        HouseDetailVo houseDetailVo = new HouseDetailVo();
        houseDetailVo.setCommunity(house.getCommunity());
        houseDetailVo.setConfiguration(house.getConfiguration());
        houseDetailVo.setCredit(user.getCredit());
        houseDetailVo.setDecoration(house.getDecoration());
        houseDetailVo.setDepositNumber(publish.getDepositNumber());
        houseDetailVo.setDescription(house.getDescription());
        houseDetailVo.setDistrict(house.getDistrict());
        houseDetailVo.setFloor(house.getFloor());
        houseDetailVo.setHall(house.getHall());
        houseDetailVo.setLocation(house.getLocation());
        houseDetailVo.setName(user.getName());
        houseDetailVo.setPayNumber(publish.getPayNumber());
        houseDetailVo.setPhone(user.getPhone());
        houseDetailVo.setPropertyCosts(house.getPropertyCosts());
        houseDetailVo.setRent(publish.getRent());
        houseDetailVo.setRoom(house.getRoom());
        houseDetailVo.setSquare(house.getSquare());
        houseDetailVo.setTitle(publish.getTitle());
        houseDetailVo.setToilet(house.getToilet());
        houseDetailVo.setTopFloor(house.getTopFloor());
        houseDetailVo.setType(house.getHouseType());
        houseDetailVo.setUserId(user.getId());
        houseDetailVo.setWay(publish.getRentWay());
        return houseDetailVo;
    }

    public ServerResponse<List<HouseRecommendListVo>> selectHouseHotOrRandomList(String type, int number){
        if(!StringUtils.isNotBlank(type)){
            return ServerResponse.createByErrorMessage("参数缺失");
        }
        List<HouseRecommendListVo> houseRecommendListVoList = new ArrayList<HouseRecommendListVo>();
        if(type.equals("hot")){
            String condition = "visit";
            houseRecommendListVoList = houseMapper.selectHouseHotOrRandomList(number,condition);
        }else if(type.equals("random")){
            String condition = "rand()";
            houseRecommendListVoList = houseMapper.selectHouseHotOrRandomList(number,condition);
        }
        return ServerResponse.createBySuccess(houseRecommendListVoList);
    }


}
