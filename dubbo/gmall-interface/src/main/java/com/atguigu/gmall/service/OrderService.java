package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddrsee;

import java.util.List;

/**
 * @author DoDayum
 * @date 2021/4/25 20:08
 */
public interface OrderService {
    
    public List<UserAddrsee> initOrder(String userId);
    
}
