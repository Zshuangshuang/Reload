/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 8:07
 */
public class MyRunnable implements Runnable{
    public void run(){
        System.out.println("我是线程");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
