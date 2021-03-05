package com.ssz.堆排序;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 时间复杂度:O(NLogN)
 * 不稳定
 * 空间复杂度:O(1)
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 8:24
 */
public class Test {
    public static void heapSort(int[] array){
        //升序排序,先将数组建立一个大堆
        creatHeap(array);
        //循环交换堆顶元素和堆中的最后一个元素,并将堆尾元素移出堆
        for (int i = 0; i < array.length-1; i++) {
            swap(array,array.length-1-i,0);
            //对堆中的元素进行向下调整
            shiftDown(array,array.length-1-i,0);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = (2*parent)+1;
        while (child < size){
            if (child+1 < size && array[child+1] < array[child]){
                child = child+1;
            }
            if (array[child] < array[parent]){
                swap(array,parent,child);
            }else {
                break;
            }
        }
        parent = child;
        child = (2*parent)+1;
    }

    private static void creatHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            shiftDown(array,array.length,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
