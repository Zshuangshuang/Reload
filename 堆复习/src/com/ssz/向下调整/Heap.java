package com.ssz.向下调整;


import java.util.Arrays;

public class Heap {

    //array代表堆结构,size代表有效长度,index表示要调整的位置
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = (parent*2)+1;
        //判断左子树是否存在
        while (child < size){
            //判断右子树是否存在,并找到左(右)子树中的较小值
            if (child+1 < size && array[child+1] < array[child]){
                child = child+1;
            }
            //判断当前父节点的值是否要调整
            if (array[parent] > array[child]){
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = (parent*2)+1;
        }
    }

    private static void swap(int[] array, int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    private static void createHeap(int[] array, int length) {
        for (int i = (length-1-1)/2; i >= 0 ; i--) {
            shiftDown(array,array.length,i);
        }
    }
}
