package com.ssz.冒泡排序;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 8:32
 */
public class Test {
    public static  void  bubbleSort(int[] array){
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                flag = false;
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            if (flag == false){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {12,21,7,8,9,10};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
