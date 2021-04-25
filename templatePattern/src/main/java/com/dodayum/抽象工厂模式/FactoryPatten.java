package com.dodayum.抽象工厂模式;

/**
 * @author DoDayum
 * @date 2021/4/20 17:35
 */
public class FactoryPatten {

    public static void main(String[] args) {

    }

}

interface Phone{}

class iPhone implements Phone{}
class HuaWeiPhone implements Phone{}

interface Factory{
    Phone createPhone();
}

class IPhoneFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new iPhone();
    }
}

class HuaWeiFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}