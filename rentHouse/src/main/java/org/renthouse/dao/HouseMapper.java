package org.renthouse.dao;

import org.apache.ibatis.annotations.Param;
import org.renthouse.pojo.House;
import org.renthouse.vo.HouseRecommendListVo;

import java.util.List;
import java.util.Map;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<Map<String,Object>>list();

    /*根据搜索条件房屋*/
    List<Map<String,Object>> search(@Param("keyword")String keyword,
                                    @Param("district")String district,
                                    @Param("lowerRent")Integer lowerRent,
                                    @Param("upperRent")Integer upperRent,
                                    @Param("room")Integer room,
                                    @Param("way")String way,
                                    @Param("type")String type,
                                    @Param("location")String location,
                                    @Param("elevator")Integer elevator,
                                    @Param("subway")String subway);

    /*根据随机或者热门房屋*/
    List<HouseRecommendListVo> selectHouseHotOrRandomList(@Param("number") Integer number,
                                                          @Param("condition") String condition);
}