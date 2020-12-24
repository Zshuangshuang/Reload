/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 8:19
 */
public class T extends Thread{
    public static void main(String[] args) {
       Thread t = new Thread(()->{
           System.out.println("我是线程");
       });
       t.start();
    }
}
