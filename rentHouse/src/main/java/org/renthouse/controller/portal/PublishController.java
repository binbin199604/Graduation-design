package org.renthouse.controller.portal;

import org.renthouse.common.ResponseCode;
import org.renthouse.common.ServerResponse;
import org.renthouse.common.UserConst;


import org.renthouse.pojo.Publish;
import org.renthouse.pojo.User;

import org.renthouse.service.PublishService;
import org.renthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>PublishController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/12</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("publish")
public class PublishController {
    @Autowired
    private PublishService publishService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveOrUpdate")
    public ServerResponse<String> saveOrUpdate(HttpSession session, Publish publish){
        User user =(User)session.getAttribute(UserConst.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录，请登录账号");
        }
//        if(userService.checkRole(user,UserConst.Role.ROLE_ADMIN).isSuccess()||
//                userService.checkRole(user,UserConst.Role.ROLE_OWNER).isSuccess()){
//            //只有房主和管理员可以添加或修改
            return publishService.saveOrUpdatePublishHouse(publish,user.getId());
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }

    @RequestMapping(value = "status")
    public ServerResponse<String> setStatus(HttpSession session,@RequestParam(value = "publishId",required = true) Integer publishId,Integer status){
        User user =(User)session.getAttribute(UserConst.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录，请登录账号");
        }
//        }
//        if(userService.checkRole(user,UserConst.Role.ROLE_ADMIN).isSuccess()||
//                userService.checkRole(user,UserConst.Role.ROLE_OWNER).isSuccess()){
//            //只有房主和管理员可以删除
            return publishService.setStatusPublish(publishId,status);
//        }else {
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
    }


    @RequestMapping(value = "detail")
    public ServerResponse detail(HttpSession session, @RequestParam(value = "publishId",required = true) Integer publishId){
            return publishService.showBeforeHouseOrderInfo(publishId);
    }
    

}
