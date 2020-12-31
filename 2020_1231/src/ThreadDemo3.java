/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 18:28
 */
public class ThreadDemo3 {
    static class MyBlockingQueue{
        private int head = 0;
        private int tail = 0;
        private static volatile int size = 0;
        private int[] array = new int[1000];
        //入队列操作
        public void put(int value)  {
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
        //出队列操作
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
        Thread producer = new Thread(){
            @Override
          public void run(){
                for (int i = 0; i < 1000; i++) {
                    queue.put(i);
                    System.out.println("生产者生产元素："+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
          }
        };
        producer.start();
        Thread customer = new Thread(){
          @Override
          public void run(){
              while(true){
                  int ret = queue.take();
                  System.out.println("消费者消费元素:"+ret);
              }
          }
        };
        customer.start();
    }
}
