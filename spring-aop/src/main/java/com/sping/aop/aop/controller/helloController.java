package com.sping.aop.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DoDayum
 * @date 2021/3/7 20:03
 */
@RestController
public class helloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return String.format("hello %s", name);
    }

    @GetMapping("/age")
    public String age(@RequestParam("age") Integer age){
        return String.format("年龄: %d",age);
    }

}
