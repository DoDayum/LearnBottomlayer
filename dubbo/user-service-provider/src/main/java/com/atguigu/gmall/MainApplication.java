package com.atguigu.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author DoDayum
 * @date 2021/4/25 21:07
 */
public class MainApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
