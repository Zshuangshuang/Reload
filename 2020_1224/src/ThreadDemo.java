/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 7:42
 */
public class ThreadDemo extends Thread{
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread:"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo thread = new ThreadDemo();
        thread.start();
        Thread.sleep(2000);
        System.out.println("OK");
    }
}
