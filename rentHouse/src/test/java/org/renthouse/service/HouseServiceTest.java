package org.renthouse.service;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.renthouse.common.ServerResponse;
import org.renthouse.test.TestBase;
import org.renthouse.vo.HouseDetailVo;
import org.renthouse.vo.HouseRecommendListVo;
import org.renthouse.vo.HouseSearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public class HouseServiceTest extends TestBase{

    private Logger logger = LoggerFactory.getLogger(HouseServiceTest.class);

    @Autowired
    private HouseService houseService;

    @Test
    public void listHouse()throws Exception{
        String orderBy = null;
        Integer pageNum = 1;
        Integer pageSize = 10;
        ServerResponse<PageInfo> serverResponse = houseService.listHouse(orderBy,pageNum,pageSize);
        System.out.println(serverResponse.toString());
    }

    @Test
    public void testSearch(){
//        String district=null;
//        Integer upperRent = 10000;
//        Integer lowerRent = 1000;
//        Integer room = null;
//        String way =null;
//        String type= null;
//        String location = null;
//        Integer elevator = null ;
//        String subway = null;
        String keyword =null;
        int pageNum = 1;
        int pageSize = 10;
        HouseSearchVo houseSearchVo = new HouseSearchVo();
        houseSearchVo.setRoom(2);
        String orderBy = "";
        ServerResponse serverResponse = houseService.searchHouse(houseSearchVo,keyword,orderBy,pageNum,pageSize);
        PageInfo pageInfo=(PageInfo) serverResponse.getData();
        logger.info(ToStringBuilder.reflectionToString(pageInfo));
    }

    @Test
    public void testSelectHouseDetail(){
        Integer publishId = 1;
        ServerResponse<HouseDetailVo> serverResponse=houseService.selectHouseDetail(publishId);
        HouseDetailVo houseDetailVo = serverResponse.getData();
        logger.info(ToStringBuilder.reflectionToString(houseDetailVo));
    }

    @Test
    public void testSelectHouseHotOrRandomList(){
        //String type = "hot";
        String type = "random";
        int number = 5;
        ServerResponse<List<HouseRecommendListVo>> serverResponse = houseService.selectHouseHotOrRandomList(type,number);
        List<HouseRecommendListVo> houseRecommendListVoList = serverResponse.getData();
        logger.info(ToStringBuilder.reflectionToString(houseRecommendListVoList));
        for(HouseRecommendListVo houseRecommendListVo : houseRecommendListVoList){
            logger.info(houseRecommendListVo.toString());
        }
    }


}