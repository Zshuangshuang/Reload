package com.zss.最小栈;

import java.util.Stack;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-15 11:10
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
            return;
        }
        int min = minStack.peek();
        if (x < min){
            min = x;
        }
        minStack.push(min);
    }

    public Integer pop() {
        if (stack.isEmpty()){
            return null;
        }
        minStack.pop();
        return stack.pop();
    }

    public Integer top() {
        if (stack.isEmpty()){
            return null;
        }
        return stack.peek();
    }

    public Integer getMin() {
        if (minStack.isEmpty()){
            return null;
        }
        return minStack.peek();
    }
}
