import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:ZouDouble
 * Description:线程池
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 15:56
 */
public class ThreadDemo {

    //此处的类用来描述当前的工作线程
    static class Worker extends Thread{
        //每个worker线程都需要从任务队列中获取任务
        //需要能够获取到任务实例
        private BlockingQueue<Runnable> queue = null;
        private int id;
        public Worker(BlockingQueue<Runnable> queue,int id){
            this.queue = queue;
            this.id = id;
        }
        @Override
        public void run(){
            //此处的try包裹了while()
            //目的是只要线程出现异常，那么就会立刻中断
        try {
                while(!Thread.currentThread().isInterrupted()){
                            Runnable command = queue.take();
                    System.out.println("线程"+this.id+"正在执行");
                            command.run();
                }
            } catch (InterruptedException e) {
            System.out.println("线程被中断");
        }
        }
    }
    //此处的类表示线程池
    static class MyThreadPool{
        //阻塞队列用于组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //List用于组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        //设置阈值
        private static final int maxWorkerCount = 10;
        //实现execute和shutDown方法
        public void execute(Runnable command) throws InterruptedException {
            //使用懒汉模式的延时加载
            //当线程池中的数目较少就创建新线程，当大于阈值的时候就直接使用线程池中的线程
            if (workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }
        public void shutDown() throws InterruptedException {
            //终止掉所有线程
            for (Worker worker : workers){
                worker.interrupt();
            }
            //回收每个线程
            for (Worker worker:workers){
                worker.join();
            }
        }
    }
        static class Command implements Runnable{
            private int num;
            public Command(int num){
                this.num = num;
            }

            @Override
            public void run() {
                System.out.println("正在执行任务："+num);
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
