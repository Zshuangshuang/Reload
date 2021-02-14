package com.ssz.给定一个数组将奇数放于偶数之后;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:Array中元素的顺序会发生改变
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-07 9:58
 */
public class TestDemo {
    public static void swap(int[] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    public static void change(int[] arr){
       int left = 0;
       int right = arr.length-1;
       while(left < right){
           if (left < right && arr[left]%2 == 0){
               left++;
           }
           if (left<right && arr[right]%2 != 0){
               right--;
           }
           swap(arr,left,right);
       }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,6,7,8};
        change(array);
        System.out.println(Arrays.toString(array));
    }
}
