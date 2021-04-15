package test;

/**
 * @author DoDayum
 * @date 2021/4/13 21:47
 */
public class CookingFood extends Cooking {
    @Override
    protected void step1() {
        System.out.println("放鸡蛋");
    }

    @Override
    protected void step2() {
        System.out.println("放西红柿");
    }
}
