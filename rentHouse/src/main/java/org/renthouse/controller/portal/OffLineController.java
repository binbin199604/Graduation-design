package org.renthouse.controller.portal;

import net.sf.jsqlparser.schema.Server;
import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.OffLine;
import org.renthouse.service.OffLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>OffLineController</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/31</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
@RestController
@RequestMapping("offLine")
public class OffLineController {
//    @Autowired
//    private OffLineService offLineService;
//
//    @RequestMapping("saveOfUpdate")
//    public ServerResponse saveOrUpdate(HttpSession httpSession, OffLine offLine){
//        return offLineService.saveOrUpdateOffLine(offLine);
//    }

}
