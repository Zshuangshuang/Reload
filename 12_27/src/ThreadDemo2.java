import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 14:25
 */
public class ThreadDemo2 {
    //此处的Task描述的是一个一段要执行的任务逻辑,由于一会儿要在优先级阻塞队列中使用
    //所以Task类要可比较
    static class Task implements Comparable<Task>{
        //Runnable中有一个run()用来描述要执行任务的内容
        private Runnable command;
        //执行任务的时间,此处是一个相对时间
        private long time;
        public Task(Runnable command,long after){
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time-o.time);
        }
        public void run(){
            command.run();
        }
    }
    //扫描线程类
    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox){
            this.queue = queue;
            this.mailBox = mailBox;
        }
        public void run(){
            while(true){
                //取出队首元素，判断是否时间到了
                try {
                    Task task = queue.take();
                    //检查当前任务时间是否到了
                    long curTime = System.currentTimeMillis();
                    //任务时间大于当前时间，证明时机未到，就把任务塞回优先级队列
                    //此处有可能出现"忙等现象"，CPU一直在不停地比较执行任务时间和curTime,造成资源浪费
                    if (task.time > curTime){
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time - curTime);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
        }
    }
    static class Timer{
        //为了避免忙等现象，需要借用辅助对象
        private Object mailBox = new Object();
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        public Timer(){
            //创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        //提供方法，安排任务，让调用者调用
        public void schedule(Runnable command,long after){
                Task task = new Task(command,after);
                queue.put(task);
                synchronized (mailBox){
                    mailBox.notify();
                }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this,1000);
            }
        },1000);
    }
}
