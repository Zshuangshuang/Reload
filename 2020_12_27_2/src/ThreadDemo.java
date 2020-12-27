/**
 * Author:ZouDouble
 * Description:阻塞队列
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 18:03
 */
public class ThreadDemo {
    static class BlockingQueue {
        private int head = 0;
        private int tail = 0;
        //此处的size设计要读取判断和修改，可能会出错，因此要加上volatile关键字
        private volatile int size = 0;
        private int[] array = new int[1000];

        public void put(int value) {
            //由于此处的修改操作非原子性，那么就需要给当前对象加锁
            synchronized (this) {
                //判断当前队列是不是满了，若队列已满就阻塞
                while (tail == array.length) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    array[tail] = value;
                    tail++;
                    if (tail == array.length) {
                        tail = 0;
                    }
                    size++;
                    //已经完成插入操作，可以唤醒线程(这里是唤醒出队列线程)
                    notifyAll();
                }
            }

        }

        public int take() {
            int ret = -1;
            //由于此处的修改操作非原子性，那么就需要给当前对象加锁
            synchronized (this) {
                //判断当前队列是不是为空，如果为空就阻塞
                while (size == 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    ret = array[head];
                    head++;
                    if (head == array.length) {
                        head = 0;
                    }
                    //出队列操作已完成，可以唤醒线程(这里是唤醒入队列线程)
                    size--;
                    notifyAll();
                }
                return ret;
            }

        }
    //模拟生产者消费者
        public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        Thread producer = new Thread(){
          public void run(){
              for (int i = 0; i < 10000; i++) {
                  queue.put(i);
                  try {
                      Thread.sleep(500);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("生产者生产元素："+i);
              }
          }
        };
        producer.start();
        Thread costumer = new Thread(){
           public void run(){
               while(true){
                   int ret = queue.take();
                   System.out.println("消费者消费元素:"+ret);
               }
           }
        };
        costumer.start();
        }
    }
}
