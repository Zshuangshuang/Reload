/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 10:52
 */
public class ThreadDemo3 {
    static class SingleTon{
        //将SingleTon的无参构造方法设置为private，这样它就只能在类内实例对象，不支持类外实例化对象
        private SingleTon(){

        }
        //将SingleTon实例对象设置为static，这样就仅有一份实例且不依赖于对象，仅与类有关
        private static SingleTon instance = new SingleTon();
        //获取SingleTon实例的方法
        public static SingleTon getInstance(){
            return instance;
        }
    }
    public static void main(String[] args) {
        SingleTon s = SingleTon.getInstance();
    }
}
