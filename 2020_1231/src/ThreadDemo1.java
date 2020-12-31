/**
 * Author:ZouDouble
 * Description:单例模式中的饿汉模式  在类加载过程中就初始化实例，线程安全
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 18:20
 */
public class ThreadDemo1 {
    static class SingleTon{
        //私有的构造方法，仅支持类内访问，不支持类外访问
        private SingleTon(){

        }
        //static静态成员变量有且仅有一份
        private static SingleTon instance = new SingleTon();
        private SingleTon getInstance(){
            return instance;
        }
    }
}
