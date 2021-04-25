package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddrsee;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DoDayum
 * @date 2021/4/25 20:09
 */
@Service
public class OrderServiceImpl implements OrderService {

    //@Resource
    @Reference
    private UserService userService;

    public List<UserAddrsee> initOrder(String userId) {
        System.out.println(String.format("用户ID:%s", userId));
        return userService.getUserAddressList(userId);
    }
}
