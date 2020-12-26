/**
 * Author:ZouDouble^_^
 * Description:
 * Exception in thread "main" java.lang.IllegalMonitorStateException非法监视器状态异常
 * 因此wait方法必须在synchronized中使用
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-26 19:28
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("触发等待前");
        synchronized (o){
            try{
                o.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("等待后");
        }
    }
}
