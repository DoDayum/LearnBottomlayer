package com.dodayum.单例模式;

/**
 * @author DoDayum
 * @date 2021/4/20 16:29
 */
public class SingleObject {

    /**
     * 饿汉式:不管什么,先创建对象
     * 懒汉式:有第一个调用时,再创建对象
     * 双锁:为懒汉式,防止并发下可能创建多个问题(注意15行修饰符和22-26行)
     */

    private volatile static SingleObject instance = new SingleObject();      //饿汉式

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    public synchronized static SingleObject getInstance(){
        if (instance == null)       //懒汉式
            synchronized (SingleObject.class) {
                if (instance == null)
                    instance = new SingleObject();
            }
        return instance;
    }

    public void showMessage(){
        System.out.println("单例模式!");
    }

}
