/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-20 21:48
 */
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        ListNode pHead = new ListNode(-1);
        ListNode head = pHead;
        ListNode headA = a;
        ListNode headB = b;
        int sum = 0;
        while(headA != null || headB != null || sum != 0){
            if (headA != null){
                sum += headA.val;
                headA = headA.next;
            }
            if (headB != null){
                sum += headB.val;
                headB = headB.next;
            }
            head.next = new ListNode(sum%10);
            sum = sum/10;
            head = head.next;
        }
        return pHead.next;
    }

}
