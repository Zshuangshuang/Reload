/**
 * Author:ZouDouble^_^
 * Description:
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-24 20:36
 */
public class ThreadDemo3 {
    static class Test{
        public void test(){
            synchronized (this){
                System.out.println("HeHe");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
}
