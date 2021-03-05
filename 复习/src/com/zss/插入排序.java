package com.zss;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 21:08
 */
public class 插入排序 {
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound-1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp){
                    array[cur+1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
