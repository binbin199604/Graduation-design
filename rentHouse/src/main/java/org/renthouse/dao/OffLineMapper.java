package org.renthouse.dao;

import org.renthouse.pojo.OffLine;

public interface OffLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OffLine record);

    int insertSelective(OffLine record);

    OffLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OffLine record);

    int updateByPrimaryKey(OffLine record);
}