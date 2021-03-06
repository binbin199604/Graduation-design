package org.renthouse.service;

import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.Comment;


/**
 * <dl>
 * <dt>CommentService</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/29</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public interface CommentService {
    //更新和保存信息
    ServerResponse saveOrUpdateComment(Comment comment);
}
