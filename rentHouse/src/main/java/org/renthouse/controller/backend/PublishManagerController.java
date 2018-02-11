package org.renthouse.controller.backend;

import org.renthouse.common.ResponseCode;
import org.renthouse.common.ServerResponse;
import org.renthouse.common.UserConst;
import org.renthouse.pojo.User;
import org.renthouse.service.HouseService;
import org.renthouse.service.PublishService;
import org.renthouse.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>PublishManagerController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/12</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("/publish/manage")
public class PublishManagerController {
//
//    private static  final Logger logger = LoggerFactory.getLogger
//            (PublishManagerController.class);
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PublishService publishService;
//
//    @RequestMapping(value = "search")
//    public ServerResponse searchPublishHouse(HttpSession session,String keyword,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
//                                      @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
//        User user = (User)session.getAttribute(UserConst.CURRENT_USER);
//        if(user == null){
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,请登录管理员账号");
//        }
//        if(userService.checkRole(user,UserConst.Role.ROLE_ADMIN).isSuccess()){
//            return publishService.search(keyword,pageNum,pageSize);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
//    }

}
