/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 10:30
 */

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 这里我假设两个线程各自自增10000次
 * 预期结果是它们自增的总次数应该是20000
 * */
public class ThreadDemo2 {
    static class Counter{
        public int count;
       synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
          public void run(){
              for (int i = 0; i < 10000; i++) {
                  counter.increase();
              }
          }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              for (int i = 0; i < 10000; i++) {
                  counter.increase();
              }
          }
        };
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.count);
    }

}
