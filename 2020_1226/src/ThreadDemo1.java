import java.util.Scanner;

/**
 * Author:ZouDouble^_^
 * Description:Volatile关键字的作用：
 * 保持内存可见性!针对一个线程读，一个线程写;或者多个线程读，多个线程写操作，修改操作可能不会生效，就要使用volatile关键字
 * 多个线程进行写操作，应该给该线程加锁，也就是使用volatile关键字
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-26 18:47
 */
public class ThreadDemo1 {
    static class Counter{
        public volatile int flag = 0;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
          public void run(){
              while (counter.flag == 0){

              }
              System.out.println("你是猪");
          }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              System.out.println("请输入一个数字:");
              Scanner scanner = new Scanner(System.in);
              counter.flag = scanner.nextInt();
          }
        };
        t2.start();
    }

}
