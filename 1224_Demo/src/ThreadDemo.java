/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 8:14
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(){
          public void run(){
              System.out.println("我是线程");
          }
        };
        thread.start();
    }
}
