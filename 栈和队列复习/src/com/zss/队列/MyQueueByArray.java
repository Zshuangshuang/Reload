package com.zss.队列;

public class MyQueueByArray {
    public int[] array = new int[100];
    public int head = 0;
    public int tail = 0;
    public int usedSize = 0;
    public void offer(int val){
        if (usedSize == array.length){
            return;
        }
        array[tail] = val;
        tail++;

        if (tail >= array.length){
            tail = 0;
        }
        this.usedSize++;
    }
    public Integer poll(){
        if (usedSize == 0){
            return null;
        }
        int ret = array[head];
        head++;
        if (head >= array.length){
            head=0;
        }
        this.usedSize --;
        return ret;
    }
    public Integer peek(){
        if (usedSize == 0){
            return null;
        }
        int ret = array[head];
        return ret;
    }
}
