package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddrsee;

import java.util.List;

/**
 * @author DoDayum
 * @date 2021/4/25 20:54
 */
public interface UserService {
    public List<UserAddrsee> getUserAddressList(String userId);
}
