package com.atguigu.gmall;

import com.atguigu.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author DoDayum
 * @date 2021/4/25 21:26
 */
public class MainApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.initOrder("1");

        System.out.println("调用完成");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
