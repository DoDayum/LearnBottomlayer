package com.dodayum.工厂模式;

/**
 * @author DoDayum
 * @date 2021/4/20 17:30
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
