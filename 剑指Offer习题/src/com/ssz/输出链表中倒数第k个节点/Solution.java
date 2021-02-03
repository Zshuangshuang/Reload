package com.ssz.输出链表中倒数第k个节点;


 class ListNode{
     int val;
     ListNode next;
     public ListNode(int val){
         this.val = val;
     }
 }
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        //判断参数的合法性
      if (head == null){
          return null;
      }
      if (k <= 0){
          return null;
      }
      ListNode fast = head;
      ListNode slow = head;
        for (int i = 0; i < k-1; i++) {
            if (fast.next != null){
                fast = fast.next;
            }else {
                return null;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}