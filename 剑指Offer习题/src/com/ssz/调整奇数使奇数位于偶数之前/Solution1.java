package com.ssz.调整奇数使奇数位于偶数之前;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    private boolean isOddNum(int num){
        if ((num&1) == 1){
            return true;
        }
        return false;
    }

    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 1){
            return;
        }
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (isOddNum(array[i])){
                oddQueue.offer(array[i]);
            }else {
                evenQueue.offer(array[i]);
            }
        }
        int i = 0;
        while(!oddQueue.isEmpty()){
            array[i++] = oddQueue.poll();
        }
        while(!evenQueue.isEmpty()){
            array[i++] = evenQueue.poll();
        }
    }
}