/**
 * Author:ZouDouble
 * Description:懒汉模式
 * 类加载的时候没有立刻实例化，第一次调用getInstance的时候才实例化，延时加载
 * 懒汉模式线程不安全，因为操作非原子性
 * 天气：晴天
 * 目标：Offer
 * Date    2020-12-26 21:53
 */
public class ThreadDemo2 {
    static class SingleTon{
        private SingleTon(){

        }
        //虽然加锁了，但是存在先加锁的线程在修改，后加锁的线程在读取，会引起内存可见性问题,
        // 因此要给instance加上volatile关键字
        private volatile static SingleTon instance = null;

        public static SingleTon getInstance(){
            //此处用一个if判断语句判断instance是否为空，如果为空就给它加锁，保证操作的原子性
            //加上if语句的原因是减少加锁的开销
            if (instance == null){
                synchronized (SingleTon.class){
                    //此处的if语句是判断是否要实例化SingleTon对象
                    if (instance == null){
                        instance = new SingleTon();
                    }

                }

            }
            return instance;
        }
    }

    public static void main(String[] args) {
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();
        System.out.println(s1 == s2);
    }
}
