import java.util.EventObject;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 18:29
 */
public class MyEvent extends EventObject {
    int maxNum;
    int curNum;
    public MyEvent(Object source,int maxNum,int curNum) {
        super(source);
        this.maxNum = maxNum;
        this.curNum = curNum;
    }
}
