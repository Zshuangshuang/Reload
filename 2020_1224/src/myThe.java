/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 8:00
 */
public class myThe implements Runnable {
    public void run(){

    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        System.out.println(2);
        t.start();
    }
}
