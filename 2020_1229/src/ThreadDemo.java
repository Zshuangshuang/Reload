import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:ZouDouble
 * Description:线程池，越长大越难受
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-29 21:40
 */
public class ThreadDemo {
    static class MyThreadPool{
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    }
    static class Worker extends Thread{
        //每个worker线程都需要从任务队列中获取任务实例
        private BlockingQueue<Runnable> queue = null;
        public Worker(BlockingQueue<Runnable> queue){
            this.queue = queue;
        }
        public void run(){
            try{
                while(!Thread.currentThread().isInterrupted()){
                        Runnable command = queue.take();
                        command.run();
                }
            }catch (InterruptedException e){
                System.out.println("当前线程已经结束");
            }
        }
    }
    public static void main(String[] args) {

    }
}
