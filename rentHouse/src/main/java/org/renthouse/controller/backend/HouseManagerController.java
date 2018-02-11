package org.renthouse.controller.backend;

import org.renthouse.common.Const;
import org.renthouse.common.ResponseCode;
import org.renthouse.common.ServerResponse;
import org.renthouse.common.UserConst;
import org.renthouse.controller.portal.HouseController;
import org.renthouse.pojo.House;
import org.renthouse.pojo.User;
import org.renthouse.service.HouseService;
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
 * <dt>HouseManagerController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/12</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("/house/manage")
public class HouseManagerController {

//    private static  final Logger logger = LoggerFactory.getLogger(HouseManagerController.class);
//
//    @Autowired
//    private HouseService houseService;
//
//    //更新或者保存房屋信息
//    @RequestMapping("saveOrUpdate")
//    public ServerResponse saveOrUpdate(HttpSession session, House house) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
//        }
////        if(iUserService.checkAdminRole(user).isSuccess()){
////            //填充我们增加产品的业务逻辑
////            return iProductService.saveOrUpdateProduct(product);
////        }else{
////            return ServerResponse.createByErrorMessage("无权限操作");
////        }
//        return houseService.saveOrUpdateHouse(house);
//    }
//



}
