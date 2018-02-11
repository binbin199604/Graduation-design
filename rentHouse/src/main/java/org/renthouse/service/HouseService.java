package org.renthouse.service;

import com.github.pagehelper.PageInfo;
import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.House;
import org.renthouse.vo.HouseDetailVo;
import org.renthouse.vo.HouseRecommendListVo;
import org.renthouse.vo.HouseSearchVo;

import java.util.List;

public interface HouseService {
    //更新和保存房屋信息
    ServerResponse saveOrUpdateHouse(House house);
    /*房屋列表*/
    public ServerResponse<PageInfo> listHouse(String orderBy,int pageNum, int pageSize);
    //搜索条件房屋
    ServerResponse<PageInfo> searchHouse(HouseSearchVo houseSearchVo,String keyword,String orderBy,int pageNum, int pageSize);
    //查询房屋详细信息
    ServerResponse<HouseDetailVo> selectHouseDetail(Integer publishId);
    //热门房屋或随机列表信息
    ServerResponse<List<HouseRecommendListVo>> selectHouseHotOrRandomList(String type, int number);


}
