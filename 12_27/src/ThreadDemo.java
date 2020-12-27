/**
 * Author:ZouDouble
 * Description:阻塞队列
 * 模拟实现生产者消费者
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 13:07
 */
public class ThreadDemo {
    static class BlockingQueue{
        //为了防止线程不安全，给属性加上volatile
        private volatile int head = 0;
        private volatile int tail = 0;
        private volatile int size = 0;
        private int[] array = new int[1000];
    //入队列操作
        public void put(int value){
            synchronized (this){
                //当前队列已满，进入阻塞状态，当其他线程有元素出队列才能继续进行入队列操作
               while (size == array.length){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //循环队列尾插元素
                array[tail] = value;
                tail++;
                if (tail == array.length){
                    tail = 0;
                }
                size++;
                //此处的notify是唤醒出队列操作
                notifyAll();
            }


        }
        //出队列操作
        public int take(){
            int ret = -1;
            //当前队列如果已经为空，出队列操作就会被阻塞，只有其他线程进行入队列操作将其唤醒才可以继续进行出队列操作
            synchronized (this){
                while (size == 0){
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
                //此处的notify是唤醒入队列线程
                notifyAll();
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread producer = new Thread(){
          public void run(){
              for (int i = 0; i < 10000; i++) {
                  blockingQueue.put(i);
                  System.out.println("生产元素："+i);
                  try {
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
        };
        producer.start();
        Thread consumer = new Thread(){
          public void run(){
              while(true){
                  int ret = blockingQueue.take();
                  System.out.println("消费元素"+ret);
              }
          }
        };
        consumer.start();
    }
}
