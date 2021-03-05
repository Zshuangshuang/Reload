package com.zss;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-05 21:23
 */
public class 堆排序 {
    public static void heapSort(int[] array){
        if (array.length <= 1){
            return;
        }
        createHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array,0,array.length-1-i);
            shiftDown(array,array.length-1-i,0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = (2*parent)+1;
        while (child < size){
            if (child+1 < size && array[child+1] > array[child]){
                child = child+1;
            }
            if (array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = (parent*2)+1;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void createHeap(int[] array) {
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
