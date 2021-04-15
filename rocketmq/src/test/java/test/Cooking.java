package test;

/**
 * @author DoDayum
 * @date 2021/4/13 21:46
 */
abstract public class Cooking {

    protected abstract void step1();
    protected abstract void step2();

    public void cook(String foodName){
        System.out.println("开始做饭");
        step1();
        step2();
        System.out.println("做饭完成");
    }

}
