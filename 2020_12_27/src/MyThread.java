/**
 * Author:ZouDouble
 * Description:创建线程的方式
 * Date    2020-12-27 10:02
 */
public class MyThread extends Thread {
    //run方法中的代码块是线程调用start方法获得CPU时执行的语句
    @Override
    public void run() {
        System.out.println("我是继承Thread的线程");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
