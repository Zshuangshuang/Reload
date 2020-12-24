import java.util.Scanner;

/**
 * Author:ZouDouble^_^
 * Description:
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-24 20:42
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(){
          public void run(){
              Scanner scanner = new Scanner(System.in);
              synchronized (locker){
                  System.out.println("请输入一个数字：");
                  int num = scanner.nextInt();
              }
          }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              while(true){
                  synchronized (locker){
                      System.out.println("t2获取到锁");
                  }
              }
          }
        };
        t2.start();
    }
}
