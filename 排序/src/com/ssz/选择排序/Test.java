package com.ssz.选择排序;


import java.util.Arrays;

public class Test {
    public static void selectSort(int[] array){
        //将数组分为已排序区间:[0,bound)
        //未排序区间:[bound,array.length)
        //每一次比较相邻元素,类似于打擂过程,每一次得到的都是待排序区间的最小值
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
