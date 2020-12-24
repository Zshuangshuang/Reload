/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 8:05
 */
public class MyThread extends Thread {
    public void run(){
        System.out.println("我是线程");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
