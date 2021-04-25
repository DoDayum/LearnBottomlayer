package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddrsee;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author DoDayum
 * @date 2021/4/25 20:02
 */
@Service
public class UserServiceImpl implements UserService {
    public List<UserAddrsee> getUserAddressList(String userId) {
        UserAddrsee user1 = new UserAddrsee(1, "辽宁", "1", "白", "123", "Y");
        UserAddrsee user2 = new UserAddrsee(2, "杭州", "2", "黑", "456", "N");
        return Arrays.asList(user1,user2);
    }
}
