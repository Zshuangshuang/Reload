package com.ssz.插入排序;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 稳定性:稳定
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-04 8:27
 */
public class Test {
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            int ret = array[bound];
            int cur = bound-1;
            for (; cur >= 0; cur--) {
                if (array[cur] > ret){
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur+1] = ret;
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
