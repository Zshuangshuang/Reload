/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-28 19:00
 */
public class ThreadDemo {
    static class SingleTon{
        //私有的构造方法，限制SingleTon只能在当前类实例化对象
        private SingleTon(){

        }
        //static不依赖于对象，有且仅有一份
        //instance涉及读取判断和实例化修改操作，因此需要volatile关键字保持内存可见性
        private volatile static SingleTon instance = null;
        public static SingleTon getInstance(){
            //此处的if判断语句可以减少加锁的开销，只需要在第一次实例化的时候加锁
            if (instance == null){
                //实例化过程不发生在类加载过程中,实例化操作非原子性，需要加锁
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
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        System.out.println(singleTon1 == singleTon2);

    }
}
