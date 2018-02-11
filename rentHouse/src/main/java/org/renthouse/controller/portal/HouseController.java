package org.renthouse.controller.portal;

import com.github.pagehelper.PageInfo;
import org.renthouse.common.Const;
import org.renthouse.common.ResponseCode;
import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.House;
import org.renthouse.pojo.User;
import org.renthouse.service.HouseService;
import org.renthouse.vo.HouseSearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>HouseController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/31</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("house")
public class HouseController {

    private static  final Logger logger = LoggerFactory.getLogger(HouseController.class);

    @Autowired
    private HouseService houseService;

    /*房屋列表 控制器*/
    @RequestMapping("list")
    public ServerResponse<PageInfo> list(@RequestParam(value = "orderBy",defaultValue = "") String orderBy,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        return houseService.listHouse(orderBy,pageNum,pageSize);
    }

    /*搜索房屋列表 控制器*/
    @RequestMapping("search")
    public ServerResponse<PageInfo> search(@RequestParam(value = "HouseSearchVo") HouseSearchVo houseSearchVo,
                                           @RequestParam(value = "keyword",required = false) String keyword,
                                           @RequestParam(value = "orderBy",defaultValue = "") String orderBy,
                                           @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return houseService.searchHouse(houseSearchVo, keyword, orderBy, pageNum, pageSize);
    }


    //查询房屋详细
    @RequestMapping("detail")
    public ServerResponse detail(@RequestParam(value = "publishId") Integer publishId) {
        //填充业务
        return houseService.selectHouseDetail(publishId);
    }

    //查询随机和热门房屋列表 type类型 number一次检索的数量
    @RequestMapping("hotOrRandom")
    public ServerResponse hotOrRandom(@RequestParam(value = "type") String type, @RequestParam(value = "number") Integer number) {
        return houseService.selectHouseHotOrRandomList(type, number);
    }


    //更新或者保存房屋信息
    @RequestMapping("saveOrUpdate")
    public ServerResponse saveOrUpdate(HttpSession session, House house) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
//        if(iUserService.checkAdminRole(user).isSuccess()){
//            //填充我们增加产品的业务逻辑
//            return iProductService.saveOrUpdateProduct(product);
//        }else{
//            return ServerResponse.createByErrorMessage("无权限操作");
//        }
        return houseService.saveOrUpdateHouse(house);
    }

}
