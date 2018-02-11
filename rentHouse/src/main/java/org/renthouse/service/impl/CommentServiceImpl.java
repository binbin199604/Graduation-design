package org.renthouse.service.impl;

import org.renthouse.common.ServerResponse;
import org.renthouse.dao.CommentMapper;
import org.renthouse.pojo.Comment;
import org.renthouse.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dt>CommentServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public ServerResponse saveOrUpdateComment(Comment comment) {
        if(comment != null)
        {
            if(comment.getId() != null){
                int rowCount = commentMapper.updateByPrimaryKey(comment);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新评论成功");
                }
                return ServerResponse.createBySuccess("更新评论失败");
            }else{
                int rowCount = commentMapper.insert(comment);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增评论成功");
                }
                return ServerResponse.createBySuccess("新增评论失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新评论参数不正确");

    }



}
