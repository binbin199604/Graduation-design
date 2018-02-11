package org.renthouse.dao;

import org.renthouse.pojo.Publish;

public interface PublishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publish record);

    int insertSelective(Publish record);

    Publish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publish record);

    int updateByPrimaryKey(Publish record);


}