package com.atguigu.gmall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author DoDayum
 * @date 2021/4/25 19:57
 */
@Data
@AllArgsConstructor
public class UserAddrsee implements Serializable {

    private Integer id;
    private String userAddress;
    private String userId;
    private String consignee;
    private String phoneNum;
    private String isDefault;

}
