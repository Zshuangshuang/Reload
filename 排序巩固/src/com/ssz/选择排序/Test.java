package com.ssz.选择排序;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 8:14
 */
public class Test {
    public static void selectSort(int[] array){
        //每一次都会找到最小值,分为有序区间:[0,bound) 待排序区间:[bound,size)
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound+1; cur < array.length; cur++) {
                if (array[cur] < array[bound]){
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
