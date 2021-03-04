package com.ssz.堆排序;

import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 时间复杂度:O(NLogN)
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-03-04 20:45
 */
public class Test {

   public static void heapSort(int[] array){
       //首先对数组进行建大堆操作
       createHeap(array);
       //循环取堆顶元素和堆尾元素进行交换,当堆中只有一个元素的时候,整个数组就有序了
       for (int i = 0; i < array.length-1; i++) {
           swap(array,array.length-1-i,0);
           //对堆进行向下调整
           shiftDown(array,array.length-1-i,0);
       }
   }

    private static void shiftDown(int[] array, int size, int index) {
       int parent = index;
       int child = (parent*2)+1;
       while (child < size){
           if (child+1 < size && array[child+1] > array[child]){
               child = child+1;
           }
           if (array[child] > array[parent]){
               swap(array,child,parent);
           }else {
               break;
           }
       }
       parent = child;
       child = (parent*2)+1;
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
