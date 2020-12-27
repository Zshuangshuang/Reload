/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-27 10:58
 */
public class ThreadDemo5 {
    static class SingleTon{
        //将SingleTon的无参构造方法设置为private，这样它就只能在类内实例对象，不支持类外实例化对象
        private SingleTon(){

        }
        //还有一个问题，就是线程在实例化的时候编译器会自动优化，在此过程中也可能会出现现场不安全问题
        //在下面实例化SingleTon的步骤存在读操作和修改操作，因此需要使用Volatile关键字来防止过度优化早场线程不安全
        private volatile static SingleTon instance = null;
        public static SingleTon getInstance(){
            //这里存在一个线程安全问题,操作非原子性，此时我们就需要用到Synchronized关键字
            //假设存在两个线程在(2)(3)步骤中就会违背单例模式的意图，两个对象就实例对象2次，线程越多，实例的对象越多
            //实例化SingleTon的步骤:
            //(1)读取当前SingleTon对象
            //(2)判断SingleTon对象是否为null
            //(3)如果是null就new SingleTon
            //(4)返回结果
            //第一次if循环的作用是减少锁的开销，只有在第一次实例化时才会加锁
            if(instance == null){
                synchronized (SingleTon.class){
                    if (instance == null){
                        instance = new SingleTon();
                    }
                }
            }
            return instance;
        }

    }
    public static void main(String[] args) {
       SingleTon s = SingleTon.getInstance();
    }
}
