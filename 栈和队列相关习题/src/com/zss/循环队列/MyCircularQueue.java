package com.zss.循环队列;


public class MyCircularQueue {
    private int[] array;//一个固定大小的数组,用来保存循环队列中的元素
    private int usedSize = 0;//表示循环队列的有效元素个数
    private int head = 0;//表示循环队列的头的位置
    private int tail = 0;//表示循环队列的尾节点位置
    private int capacity;//表示循环队列的容量
    //构造方法
    public MyCircularQueue(int k) {
        this.array = new int[k];
        this.capacity = k;
    }
    //向循环队列中插入一个元素
    public boolean enQueue(int value) {
        //元素已满,无法插入
        if (this.usedSize == this.capacity){
            return false;
        }
        this.tail = (this.head+this.usedSize)%this.capacity;
        array[tail] = value;
        this.usedSize++;
        return true;
    }
    //出队列操作
    public boolean deQueue() {
        if (this.usedSize == 0){
            return false;
        }
        this.head = (this.head+1)%this.capacity;
        this.usedSize--;
        return true;
    }
    //取队首元素
    public int Front() {
        if (this.usedSize == 0){
            return -1;
        }
        return array[this.head];
    }
    //取队尾元素
    public int Rear() {
        if (this.usedSize == 0){
            return -1;
        }
        this.tail = (this.head+this.usedSize-1)%this.capacity;
        return array[tail];
    }

    public boolean isEmpty() {
        if (this.usedSize == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.usedSize == this.capacity){
            return true;
        }
        return false;
    }
}
