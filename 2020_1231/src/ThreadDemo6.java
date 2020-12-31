import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 19:31
 */
public class ThreadDemo6 {
    static class Task implements Comparable<Task>{
        private Runnable command;
        private long time;

        public Task(Runnable command, long after){
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }
        public void run(){
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int)(this.time-o.time) ;
        }
        static class Worker extends Thread{
            private PriorityBlockingQueue<Task> queue = null;
            private Object mailBox = null;
            public Worker(PriorityBlockingQueue<Task> queue,Object mailBox){
                this.mailBox = mailBox;
                this.queue = queue;
            }
            @Override
            public void run(){
                while(true){
                    try {
                        Task task = queue.take();
                        long curTime = System.currentTimeMillis();
                        if(task.time > curTime){
                            queue.put(task);
                            synchronized (mailBox){
                                task.wait(task.time-curTime);
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
            private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
            private Object mailBox = new Object();
            public Timer(){
                Worker worker = new Worker(queue,mailBox);
                worker.start();
            }
            public void schedule(Runnable command,long time){
                Task task = new Task(command,time);
                queue.put(task);
                synchronized (mailBox){
                    mailBox.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo4.Timer timer = new ThreadDemo4.Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("呵呵");
                timer.schedule(this,1000);
            }
        },1000);
    }
}
