import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author:ZouDouble
 * Description:定时器
 * 定时器的组成：
 * Task类负责描述任务逻辑，规定任务执行的逻辑和执行任务的时间
 * Timer类负责用阻塞优先队列来组织Task对象
 * 扫描线程用来循环检测当前进程是否可以开始执行任务
 * schedule方法负责安排任务，让调用者执行
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 18:53
 */
public class ThreadDemo4 {
    /**
     * Task类里面有两个主要的属性，Runnable类型的命令，其中有个run方法具体描述任务做的事情
     * long类型的时间
     * 由于后面需要比较时间，所以Task类需要具有比较的功能需要实现Comparable接口，重写compareTo方法
     * */
    static class Task implements Comparable<Task>{
        private Runnable command;//任务属性
        private long time;//执行任务的时间,这里是相对时间
        public Task(Runnable command,long after){
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }
       public void run(){
            command.run();
       }
       @Override
        public int compareTo(Task o){
            return (int)(this.time-o.time);
       }
    }
    //扫描线程类
    /**
     * 扫描线程类继承自Thread实现的功能主要是判断当前的进程是不是能够执行任务
     * 如果可以执行任务，直接执行run()放啊中的内容
     * 如果不可以就把它塞回阻塞队列
     * */
    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;
        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox){
            this.queue = queue;
            this.mailBox = mailBox;
        }
        @Override
        public void run(){
            while(true){
                try {
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime){
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time-curTime);
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
        //为了避免忙等状态，借助辅助对象
        //所谓忙等状态就是不停的判断当前时间和执行任务的时间，一直看时间判断时间
        private Object mailBox = new Object();
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        public Timer(){
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        public void schedule(Runnable command,long after){
            Task task = new Task(command, after);
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
                System.out.println("呵呵");
                timer.schedule(this,1000);
            }
        },1000);
    }
}
