/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-19 14:32
 */
class Node{
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class TestDemo1 {
    public  Node head;
    public void display2(Node pHead){
        Node cur = pHead;
        while(cur != null){
            System.out.printf(cur.value+" ");;
            cur = cur.next;
        }
    }
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.printf(cur.value+" ");;
            cur = cur.next;
        }
    }
    public void add(int val){
        Node node  = new Node(val);
        if (head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public  Node partition(int x){
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;
        while(cur != null){
            if (cur.value < x){
                if (bs == null){
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if (as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }

            }
            cur = cur.next;
        }
        if (bs == null){
            return as;
        }
        be.next = as;
        if (as != null){
            ae.next = null;
        }
        return bs;
    }

    public static void main(String[] args) {
        TestDemo1 testDemo1 = new TestDemo1();
        testDemo1.add(1);
        testDemo1.add(2);
        testDemo1.add(3);
        testDemo1.add(9);
        testDemo1.add(4);
        testDemo1.add(8);
        testDemo1.display();
        System.out.println();
        Node pHead = testDemo1.partition(5);
        testDemo1.display2(pHead);

    }
}
