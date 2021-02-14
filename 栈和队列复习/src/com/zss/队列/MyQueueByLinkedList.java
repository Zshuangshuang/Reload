package com.zss.队列;

/**
 * Author:ZouDouble
 * Description:采用尾部插入,头部出队列
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-14 16:53
 */
public class MyQueueByLinkedList {
   static class Node{
       public int val;
       public Node next;

       public Node(int val) {
           this.val = val;
           this.next = null;
       }
   }
   public Node head;
   public Node tail;
   //入队列
    public void offer(int val){
        Node node = new Node(val);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }
    //出队列
    public Integer pop(){
        if (head == null){
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek(){
        if (head == null){
            return null;
        }
        return head.val;
    }
}
