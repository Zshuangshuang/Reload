import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 20:18
 */
public class ThreadDemo {
    /**
     * 工作线程：功能是描述线程的属性和功能
     * */
    static class Worker extends Thread{
        private int id;
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue,int id){
            this.id = id;
            this.queue = queue;
        }
        @Override
        public void run(){
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Runnable command = queue.take();
                    System.out.println("当前线程"+this.id+"正在运行");
                    command.run();
                } catch (InterruptedException e) {
                    System.out.println("当前线程被中断");
                }
            }
        }
    }
    /**
     * 线程池类：描述了线程的管理方式，线程池中线程的阈值以及线程的核心方法
     * */
    static class MyThreadPool{
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();//管理任务的数据结构
        private List<Worker> workers = new ArrayList<>();//管理线程的数据结构
        private static final int maxThreadCount = 10;//阈值
        public void execute(Runnable command){
            //这里的添加任务采用了延时加载
            //如果线程个数没有达到阈值，就创建新线程
            //如果达到了阈值，就直接执行任务
            if(workers.size() < maxThreadCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.add(command);
        }
        public void shutDown() throws InterruptedException {
            //终止每个线程
            for (Worker worker:workers){
                worker.interrupt();
            }
            //回收每个线程
            for (Worker worker:workers){
                worker.join();
            }
        }
    }
    //任务类的属性和功能
static class Command implements Runnable{
        private int num;

    public Command(int num) {
        this.num = num;
    }

    public void run(){
        System.out.println("线程"+this.num+"running");
        }
}
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool threadPool = new MyThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Command(i));
        }
        Thread.sleep(1000);
        threadPool.shutDown();
        System.out.println("线程池被销毁");
    }
    }

