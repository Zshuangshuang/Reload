public class Plus1 {
  static  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
       if (a == null){
           return b;
       }
       if (b == null){
           return a;
       }
        ListNode headA1 = a;
        ListNode headB1 = b;
        ListNode head = new ListNode(-1);
        ListNode pHead = head;
        int sum = 0;
        while(headA1 != null || headB1 != null || sum != 0){
            if (headA1 != null){
                sum += headA1.val;
                headA1 = headA1.next;
            }
            if (headB1 != null){
                sum += headB1.val;
                headB1 = headB1.next;
            }
            head.next = new ListNode(sum%10);
            sum = sum/10;
            head = head.next;
        }
        return pHead.next;
    }
}