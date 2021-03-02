package com.ssz.用两个栈实现队列;

import java.util.Stack;

//两个栈实现一个队列就让stack1始终负责入队列,stack2始终负责出队列
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public Integer pop() {
        if (empty()){
            return null;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    private boolean empty(){
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
