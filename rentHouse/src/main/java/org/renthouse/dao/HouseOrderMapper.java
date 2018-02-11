package org.renthouse.dao;

import org.apache.ibatis.annotations.Param;
import org.renthouse.pojo.HouseOrder;

public interface HouseOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseOrder record);

    int insertSelective(HouseOrder record);

    HouseOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseOrder record);

    int updateByPrimaryKey(HouseOrder record);

    int checkToUserAndHouseOrder(@Param("toUserId") Integer toUserId,@Param("publishId") Integer publishId);
}