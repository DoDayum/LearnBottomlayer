package com.leet.code;

/**
 * @author DoDayum
 * @date 2021/4/20 15:19
 */
public class code {

    public static void main(String[] args) {
        Integer[] b = new Integer[100];
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for (int value : a) {
            System.out.println("" + value);
        }

    }

}
