package com.zss;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 21:19
 */
public class 冒泡排序 {
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
