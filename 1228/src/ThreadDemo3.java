/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-28 20:14
 */
public class ThreadDemo3 {
    static class Counter{
        private  int count;
        public void increase(){
            this.count++;
        }
    }
    public static void main(String[] args) {
        Object o = new Object();
        Counter counter = new Counter();
        Thread t1 = new Thread(){
          public void run(){
              synchronized (o){
                  for (int i = 0; i < 10000; i++) {
                      counter.increase();
                  }
              }
              }

        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              synchronized (o){
                  for (int i = 0; i < 10000; i++) {
                      counter.increase();
                  }
              }
          }
        };
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.count);
    }
}
