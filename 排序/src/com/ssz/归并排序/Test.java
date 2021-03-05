package com.ssz.归并排序;


import java.util.Arrays;

public class Test {
    public static void merGeSort(int[] array){
        mergerSortHelper(array,0,array.length);
    }
    public static void mergerSortHelper(int[] array,int lowIndex,int highIndex){
        //size表示待排序区间
        int size = highIndex - lowIndex;
        if (size <= 1){
            return;
        }
        int middleIndex = (lowIndex + highIndex)/2;
        mergerSortHelper(array,lowIndex,middleIndex);
        mergerSortHelper(array,middleIndex,highIndex);
        merge(array,lowIndex,middleIndex,highIndex);

    }
    public static void merge(int[] array,int low,int middle,int high){
        int size = high-low;
        int[] tmp = new int[size];;
        int leftIndex = low;
        int rightIndex = middle;
        int index = 0;
        while (leftIndex < middle && rightIndex < high){
            if (array[leftIndex] <= array[rightIndex]){
                tmp[index] = array[leftIndex];
                index++;
                leftIndex++;
            }else {
                tmp[index] = array[rightIndex];
                index++;
                rightIndex++;
            }
        }
        if (leftIndex < middle){
            while (leftIndex < middle){
                tmp[index] = array[leftIndex];
                index++;
                leftIndex++;
            }
        }else {
            while (rightIndex < high){
                tmp[index] = array[rightIndex];
                index++;
                rightIndex++;
            }
        }
        for (int i = 0; i < size; i++) {
            array[low+i] = tmp[i];
        }

    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        merGeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
