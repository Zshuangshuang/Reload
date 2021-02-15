package com.zss.用栈实现队列;


import java.util.Stack;

public class MyQueue {
   Stack<Integer> A = new Stack<>();//A负责入队列
   Stack<Integer> B = new Stack<>();//B负责出队列
    public void push(int x) {
        //当B队列中有元素时，现将B中的元素清理
        while(!B.isEmpty()){
            int last = B.pop();
            A.push(last);
        }
        //A负责入队列
        A.push(x);
    }

    public Integer pop() {
        //为空时直接返回null
        if (empty()){
            return null;
        }
        //将A中的元素全部出栈至B
        while(!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        //进行出队列操作
        return B.pop();
    }

    public Integer peek() {
        if (empty()){
            return null;
        }
        while(!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
