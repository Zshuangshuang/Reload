package com.ssz.给定两个整形数组交换数组的内容;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-07 10:18
 */
public class TestDemo {
    public static void swap(int[] array1,int[] array2){
        for (int a = 0; a < array1.length; a++) {
            int tmp = array1[a];
            array1[a] = array2[a];
            array2[a] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6,7};
        swap(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
