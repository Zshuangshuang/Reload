package com.ssz.反转链表;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
       ListNode cur = head;
       ListNode prev = null;
       ListNode newHead = null;
       while(cur != null){
           ListNode curNext = cur.next;
           if (curNext == null){
               newHead = cur;
           }
           cur.next = prev;
           prev = cur;
           cur = curNext;
       }
       return newHead;
    }
}
