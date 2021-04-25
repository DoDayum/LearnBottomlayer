package test;

import java.util.Scanner;

/**
 * @author DoDayum
 * @date 2021/4/13 21:32
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String foodName = sc.nextLine();
        Cooking cooking = new CookingFood();
        cooking.cook(foodName);

    }

}

