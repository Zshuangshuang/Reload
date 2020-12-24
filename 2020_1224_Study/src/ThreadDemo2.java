/**
 * @Auther:ZouSS
 * @Description:线程安全问题
 * 为什么会出现线程不安全？
 * (1)线程的抢占式执行方式:线程间的调度完全是由内核负责，现成的先后执行顺序用户无法控制和感知
 * (2)操作非原子性:例如经典的自增操作，有三个步骤:首先将数据从内存读取到CPU的寄存器上，对数据进行自增操作(保存在寄存器中)
 * 最后将寄存器的数据写回内存，期间的操作如果是并发执行，就可能出现差错
 * (3)多个线程修改同一个变量：一个线程可以修改一个变量，多个线程尝试读取同一个变量也没问题，多个线程修改多个变量也没问题
 * (4)内存可见性
 * (5)指令重排序：代码在编译过程中，会被优化(编译器在保证不改变逻辑的情况下会调节指令顺序，提高代码的执行效率)
 *
 * 如何解决线程安全问题？
 * (1)针对线程的抢占式执行方式（由OS内核决定，无法干预）
 * (2)针对操作非原子性可以通过加锁的方式来解决
 *
 * 锁的特点：
 * 是互斥的，同一时刻只有一个进程可以获取到锁，如果其他进程也在竞争这个锁，就会发生阻塞等待;
 * 当且仅当第一个锁释放后，其他进程才能竞争锁
 * 加锁关键字：Synchronized()
 * 如何使用锁？
 * 可以给方法加锁，也可以灵活指定对象加锁
 * (1)Synchronized加在普通方法前，相当于给this加锁
 * (2)Synchronized加在静态方法前，相当于给类对象(JVM在运行时将.class文件加载到内存获取到的)加锁
 * (3)Synchronized加到某个代码块前，相当于显示指定给某个对象加锁
 * @Date 2020-12-24 19:28
 */

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
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
          public void run(){
              for (int i = 0; i < 50000; i++) {
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
