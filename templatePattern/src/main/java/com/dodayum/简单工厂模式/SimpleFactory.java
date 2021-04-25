package com.dodayum.简单工厂模式;

/**
 * @author DoDayum
 * @date 2021/4/20 17:12
 */
public class SimpleFactory {

    public static Product createProduct(String type){
        if ("A".equals(type)){
            return new ProductA();
        }else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("");
        product.print();
    }

}

abstract class Product{
    public abstract void print();
}

class ProductA extends Product{
    public void print() {
        System.out.print("实例化A");
    }
}


class ProductB extends Product{
    public void print() {
        System.out.print("实例化B");
    }
}
