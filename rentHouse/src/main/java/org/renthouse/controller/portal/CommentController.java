package org.renthouse.controller.portal;

import org.renthouse.common.Const;
import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.Comment;
import org.renthouse.pojo.User;
import org.renthouse.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>CommentController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/31</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("comment")
public class CommentController {
//    @Autowired
//    private CommentService commentService;
//
//    @RequestMapping("saveOrUpdate")
//    public ServerResponse saveOrUpdate(HttpSession httpSession, Comment comment){
//        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
//        return commentService.saveOrUpdateComment(comment);
//    }


}
