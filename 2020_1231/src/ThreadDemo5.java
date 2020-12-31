/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 18:42
 */
public class ThreadDemo5 {
    static class MyBlockingQueue{
        private int tail = 0;
        private int head = 0;
        private int size = 0;
        private int[] array = new int[1000];
        public void put(int value){
            synchronized (this){
                while(tail == array.length){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                array[tail] = value;
                tail++;
                if (tail == array.length){
                    tail = 0;
                }
                size++;
                notifyAll();
            }

        }
        public int take(){
            int ret = -1;
           synchronized (this){
               while(size == 0){
                   try {
                       wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               ret = array[head];
               head++;
               if (head == array.length){
                   head = 0;
               }
               size--;
               notifyAll();
           }
            return ret;
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread t1 = new Thread(){
          @Override
          public void run(){
              for (int i = 0; i < 10000; i++) {
                  queue.put(i);
                  try {
                      Thread.sleep(2000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("生产者生产："+i);
              }
          }
        };
        t1.start();
        Thread t2 = new Thread(){
          @Override
          public void run(){
              while(true){
                  int ret = queue.take();
                  System.out.println("消费者消费："+ret);
              }
          }
        };
        t2.start();
    }
}
