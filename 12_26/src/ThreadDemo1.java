/**
 * Author:ZouDouble^_^
 * Description:单例模式中的饿汉模式
 * 单利模式指的是保证类的实例只有一个，例如DataSource
 * 注意：静态内部类可以访问内部类的private成员
 * 对于饿汉模式来说，由于在类加载的过程中就实例化对象了，类加载仅有一次
 * 每次调用getInstance相当于多线程同时读取同一个变量，所以线程安全
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-26 21:42
 */
public class ThreadDemo1 {
    static class SingleTon{
        //定义SingleTon的构造方法为private可以使这个类只能在该类内实例对象，不支持类外实例化对象
        private SingleTon(){

        }
        //static修饰的成员有且仅有一份，只依赖于类，不依赖对象
      private static SingleTon instance = new SingleTon();
        //饿汉模式指的是在类加载过程（仅有1次）就实例化对象，线程安全
        public static SingleTon getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) {
        //通过getInstance来得到SingleTon对象
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();
        System.out.println(s1 == s2);
    }
}
