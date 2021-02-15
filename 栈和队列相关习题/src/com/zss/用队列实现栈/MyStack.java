package com.zss.用队列实现栈;


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();
    public void push(int x) {
        A.offer(x);
    }
    //出队列操作
    public Integer pop() {
    //如果为空直接返回Null
        if (empty()){
            return null;
        }
        //将A中的前n-1个元素挪到B中
        while(A.size() > 1){
            int tmp = A.poll();
            B.offer(tmp);
        }
        int ret = A.poll();
        //交换AB
        swapAB();
        return ret;
    }
    private void swapAB(){
        Queue<Integer> tmp = new LinkedList<>();
        tmp = A;
        A = B;
        B = tmp;
    }


    public Integer top() {
        if (empty()){
            return null;
        }
        while(A.size() > 1){
            int tmp = A.poll();
            B.offer(tmp);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }


    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

}
