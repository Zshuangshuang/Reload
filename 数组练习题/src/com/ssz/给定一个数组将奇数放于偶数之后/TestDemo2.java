package com.ssz.给定一个数组将奇数放于偶数之后;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-07 10:03
 */
public class TestDemo2 {
    public static void change(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j+1] %2 == 0){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        change(array);
        System.out.println(Arrays.toString(array));
    }
}
