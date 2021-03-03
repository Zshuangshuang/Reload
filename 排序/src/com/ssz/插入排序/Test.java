package com.ssz.插入排序;

import java.util.Arrays;

public class Test {
    //[0,bound)表示已排序区间
    //[bound,size)表示待排序区间
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            //记录待排序区间的第一个元素
            int ret = array[bound];
            //记录已排序区间的最后一个元素的下标
            int pos = bound-1;
            //依次比较array[pos]和ret的大小
            for (; pos >= 0 ; pos--) {
                if (array[pos] > ret){
                    array[pos+1] = array[pos];
                }else {
                    break;
                }
            }
            //最终要将待排序区间的元素放到合适的位置
            array[pos+1] = ret;
        }

    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
