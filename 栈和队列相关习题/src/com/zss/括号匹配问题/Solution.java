package com.zss.括号匹配问题;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        //(1)判断参数的合法性
        if (s == null){
            return false;
        }
        //(2)使用map和stack对s进行操作
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        //①如果s中的元素是'(','[','{'就入栈
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
                continue;
            }
            //②如果遍历完成发现栈还是null,直接返回false;
            if (stack.isEmpty()){
                return false;
            }
            //③取出栈顶元素.判定是否和map中存储的键和值匹配
            char top = stack.pop();
            //匹配则继续出队列
            if (map.get(top) == ch){
                continue;
            }
            //不匹配直接返回false
            return false;
        }
        //如果最终栈为空，则证明括号匹配
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
