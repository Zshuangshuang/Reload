import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 18:27
 */
public class ThreadDemo2 {
    //Task类负责描述执行任务的逻辑和记录执行时间,由于一会儿会在阻塞队列中使用，
    // 所以需要具备可比较功能
    static class Task implements Comparable<Task> {
        private long time;//记录相对时间
        private Runnable command;//记录一个任务

        public Task(Runnable command, long after) {
            this.command = command;
            //计算绝对时间
            this.time = System.currentTimeMillis() + after;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.time - o.time);
        }
    }

    //扫描线程类，负责判断当前线程是否可以执行
    static class Scan extends Thread {
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Scan(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        public void run() {
            while (true) {
                try {
                    Task task = queue.take();
                    long curNum = System.currentTimeMillis();
                    //如果是task执行时间大于当前时间就把它放回阻塞队列，否则执行任务
                    //这里还需要避免忙等现象，造成资源浪费
                    if (task.time > curNum) {
                        queue.put(task);
                        synchronized (mailBox) {
                            mailBox.wait(task.time - curNum);
                        }
                    } else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }

        }
    }

        //使用优先级阻塞队列组织若干个Task
        static class Timer {
            //构造一个辅助对象，避免造成忙等现象
            private Object mailBox = new Object();
            private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
            public Timer() {
                //创建线程
                Scan scan = new Scan(queue, mailBox);
                scan.start();
            }
            //安排任务的方法
            public void schedule(Runnable command,long after){
                Task task = new Task(command,after);
                queue.put(task);
                //安排任务后唤醒
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



