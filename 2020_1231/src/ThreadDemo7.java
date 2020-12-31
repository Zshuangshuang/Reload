import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:ZouDouble
 * Description:线程池
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 19:41
 */
public class ThreadDemo7 {
    //Worker类继承自Thread类，功能主要是表示工作线程，描述线程的工作内容
    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;
        private int id;
        public Worker(BlockingQueue<Runnable> queue,int id){
            this.queue = queue;
            this.id = id;
        }
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                try {
                    Runnable command = queue.take();
                    System.out.println("当前线程"+this.id+"在运行");
                    command.run();
                } catch (InterruptedException e) {
                    System.out.println("当前线程被中断");
                }
            }
        }
    }
    //线程池里面有三个主要的属性
    //(1)用来组织任务的数据结构：阻塞队列
    //(2)用来组织管理线程的数据结构：arrayList
    //(3)设置阈值：类似于懒汉模式的延时加载，线程个数小于阈值则需要创建新的任务，否则直接使用线程池中的线程
    static class MyThreadPool{
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        private List<Worker> workers = new ArrayList<>();
        private static final int maxThreadCount = 10;
        public void execute(Runnable command) throws InterruptedException {
            if (workers.size() < maxThreadCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }
        public void shutDown() throws InterruptedException {
            for (Worker worker : workers){
                worker.interrupt();
            }
            for (Worker worker:workers){
                worker.join();
            }
        }
    }
    static class Command implements Runnable{
        private int num;

        public Command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("当前"+num+"正在running");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool();
        for (int i = 0; i < 10; i++) {
            myThreadPool.execute(new Command(i));
        }
        Thread.sleep(2000);
        myThreadPool.shutDown();
        System.out.println("线程池被销毁");
    }
    }

