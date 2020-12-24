/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-24 7:28
 */
public class MyThread extends Thread{

    public static void main(String[] args) {
        MyThread thread = new MyThread(){
          public void run(){
              for (int i = 1; i < 3; i++) {
                  System.out.println("run()"+i);
              }
          }
        };
        thread.start();
        System.out.println(Thread.currentThread().getState());
    }
}
