/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 10:07
 */
public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("我是实现Runnable接口的新线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
