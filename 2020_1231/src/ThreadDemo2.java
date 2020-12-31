/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2020-12-31 18:22
 */
public class ThreadDemo2 {
    static class SingleTon{
        private SingleTon(){

        }
        //由于执行过程中，涉及到读取instance和实例化instance，编译器可能会优化代码逻辑，
        // 使得每次读取均从CPU的寄存器中读取，从而引起线程不安全
        //加上Volatile会防止由于读写同时进行引起的的线程不安全
        private static volatile SingleTon instance = null;
        //instance的读取判断和实例化操作非原子性，可能会线程不安全
        private SingleTon getInstance(){
            //第一层if的作用是为了提到代码的执行效率，避免加锁释放锁的开销
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
