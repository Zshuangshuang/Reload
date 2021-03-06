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
        //思路：将数组分为已排序区间[0,bound)
        //待排序区间[bound,size)
        for (int bound = 1; bound < array.length; bound++) {
            //记录待排序区间的第一个元素
            int tmp = array[bound];
            int cur = bound-1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp){
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            //最终将元素插入合适位置
            array[cur+1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
