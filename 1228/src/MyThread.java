/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-28 19:29
 */
public class MyThread extends Thread{
    private static Object o = new Object();// 对象锁，必须是static
    private static int count = 0;// 控制输出哪个字母
    private char ID;// 字母
    private int id;// 字母对应的数字
    private int num = 0;// 打印次数
    public MyThread(int id, char ID) {
        this.id = id;
        this.ID = ID;
    }

    @Override
    public void run() {
        synchronized (o) {
            while (num < 10) {
                if (count % 3 == id) {
                    System.out.print(ID);
                    ++count;
                    ++num;

                    // 唤醒所有等待线程
                    o.notifyAll();
                } else {
                    try {
                        // 如果不满足条件，则阻塞等待
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        (new MyThread(0, 'A')).start();
        (new MyThread(1, 'B')).start();
        (new MyThread(2, 'C')).start();
    }
}
