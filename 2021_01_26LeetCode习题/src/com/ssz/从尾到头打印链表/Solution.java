package com.ssz.从尾到头打印链表;

 class ListNode {
     int val;
     ListNode next;

     public ListNode(int x) {
         val = x;
     }
 }

class Solution {
     public int length(ListNode head){
         ListNode cur = head;
         int count = 0;
         while(cur != null){
             count++;
             cur = cur.next;
         }
         return count;
     }
    public int[] reversePrint(ListNode head) {
        ListNode pHead = new ListNode(-1);
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode curNext = cur.next;
            pHead = cur;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
       
    }
}