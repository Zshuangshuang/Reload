/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-26 23:00
 */
public class ThreadDemo3 {
    static class SingleTon{
        private SingleTon(){

        }
        private volatile static SingleTon instance = null;
        public static SingleTon getInstance(){
            if (instance == null){
                synchronized (SingleTon.class){
                    if (instance == null){
                        instance = new SingleTon();
                    }
                }
            }
            return instance;
        }
    }

}
