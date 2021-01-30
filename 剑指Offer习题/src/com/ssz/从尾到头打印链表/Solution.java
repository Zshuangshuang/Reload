package com.ssz.从尾到头打印链表;

import java.util.ArrayList;
import java.util.Stack;


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
      ArrayList list = new ArrayList();
      Stack stack = new Stack();
      while(listNode != null){
          stack.push(listNode.val);
          listNode = listNode.next;
      }
      while(!stack.isEmpty()){
          list.add(stack.pop());
      }
      return list;
    }
}
