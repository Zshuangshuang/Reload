/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 7:56
 */
public class ThreadTest extends Thread{
    private String name;
    public ThreadTest(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest A = new ThreadTest("a");
        ThreadTest B = new ThreadTest("b");
        ThreadTest C = new ThreadTest("c");
        C.start();
        C.join();
        B.start();
        B.join();
        A.start();
        A.join();
    }
}
