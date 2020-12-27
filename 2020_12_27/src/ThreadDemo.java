/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 10:09
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
          public void run(){
              System.out.println("我是线程1");
          }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("我是线程2");
            }
        };
        t2.start();
    }
}
