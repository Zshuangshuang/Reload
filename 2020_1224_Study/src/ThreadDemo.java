/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 19:17
 */
public class ThreadDemo extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {

        }
    }
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }
}
