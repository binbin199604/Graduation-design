package org.renthouse.dao;



import org.junit.Ignore;
import org.junit.Test;
import org.renthouse.test.TestBase;
import org.renthouse.vo.HouseRecommendListVo;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>HouseDaoTest</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/9/20</dd>
 * </dl>
 *
 * @author 梁浩斌
 */

public class HouseDaoTest extends TestBase{
    //注入DAO实现类依赖

    @Autowired
    private HouseMapper houseDao;

    @Test
    public void testSearch()throws Exception{
        String keyword = "%嘉福%";
        String district="蓬江区";
        Integer upperRent = 10000;
        Integer lowerRent = 1000;
        Integer room = 3;
        String way ="";
        String type= "";
        String location = "";
        Integer elevator = 0 ;
        String subway = "";
//        houseDao.search(keyword,district,upperRent,lowerRent,room,way,type,location,elevator,subway);
        List<Map<String,Object>> listMap =  houseDao.search(null,null,lowerRent,upperRent,null,null,null,null,null,null);
        for(Map<String,Object> map:listMap){
            for(Map.Entry<String,Object> entry:map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
    }


    @Test
    public  void  testSelectHouseHotOrRandomList() throws Exception{
        Integer number = 5;
        //String condition = "rand()";
        String condition = "visit";
        List<HouseRecommendListVo> houseRecommendListVoList=houseDao.selectHouseHotOrRandomList(number,condition);
    }



}