package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserAddrsee;
import com.atguigu.gmall.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DoDayum
 * @date 2021/4/25 22:16
 */
@Controller
public class OrderController {

    @Resource
    OrderService orderService;

    @ResponseBody
    @RequestMapping("initOrder")
    public List<UserAddrsee> initOrder(@RequestParam("uid") String userId){

        return orderService.initOrder(userId);

    }

}
