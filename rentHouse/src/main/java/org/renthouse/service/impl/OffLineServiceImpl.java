package org.renthouse.service.impl;

import org.renthouse.common.ServerResponse;
import org.renthouse.dao.OffLineMapper;
import org.renthouse.pojo.OffLine;
import org.renthouse.service.OffLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dt>OffLineServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@Service("offLineService")
public class OffLineServiceImpl implements OffLineService{

    @Autowired
    private OffLineMapper offLineMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ServerResponse saveOrUpdateOffLine(OffLine offLine) {
        if(offLine != null)
        {
            if(offLine.getId() != null){
                int rowCount = offLineMapper.updateByPrimaryKey(offLine);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新线下约谈成功");
                }
                return ServerResponse.createBySuccess("更新线下约谈失败");
            }else{
                int rowCount = offLineMapper.insert(offLine);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增线下约谈成功");
                }
                return ServerResponse.createBySuccess("新增线下约谈失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新线下约谈参数不正确");
    }

}
