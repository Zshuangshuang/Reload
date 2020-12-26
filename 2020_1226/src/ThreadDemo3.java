import java.util.Scanner;

/**
 * Author:ZouDouble^_^
 * Description:wait()和notify()必须在synchronized关键字中使用
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-26 19:41
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(){
            public void run(){
               synchronized(locker){
                   while (true){
                       System.out.println("wait开始前");
                       try {
                           locker.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("wait结束后");
                   }
               }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              Scanner scanner = new Scanner(System.in);
              System.out.println("请输入一个数字,要开始notify啦");
              int num = scanner.nextInt();
              synchronized (locker){
                  System.out.println();
                  System.out.println("notify前");
                  locker.notify();
                  System.out.println("notify后");
              }
          }
        };
        t2.start();
    }
}
