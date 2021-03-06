package 返回链表的倒数第K个节点;

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
       if (pHead == null || k <= 0){
           return null;
       }
       ListNode fast = pHead;
       ListNode slow = pHead;
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
