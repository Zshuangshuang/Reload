import java.util.EventObject;

/**
 * @Auther:ZouSS
 * @Description:事件方法，主要是通过传参方式给maxNum和curNum赋值
 * @Date 2020-12-20 17:46
 */
public class MyEvent extends EventObject {

    int maxNum;
    int curNum;
    public MyEvent(Object source,int maxNum,int curNum) {
        super(source);
        this.curNum = curNum;
        this.maxNum = maxNum;
    }
}
