package com.ssz.快速排序;


import java.util.Arrays;

public class Test {
    public static void qSort(int[] array){
        qSortHelper(array,0,array.length-1);
    }

    private static void qSortHelper(int[] array, int left, int right) {
        if (left >= right){
            //此时证明数组里面就只有一个元素
            return;
        }
        int index = partition(array,left,right);
        qSortHelper(array,left,index-1);
        qSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int ret = array[right];
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && array[leftIndex] <= ret){
                leftIndex++;
            }
            while (leftIndex < rightIndex && array[rightIndex] >= ret){
                rightIndex--;
            }
            swap(array,leftIndex,rightIndex);
        }
        swap(array,leftIndex,right);
        return leftIndex;
    }

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int tmp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        qSort(array);
        System.out.println(Arrays.toString(array));
    }
}
