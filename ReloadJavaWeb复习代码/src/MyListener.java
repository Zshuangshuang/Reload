import java.util.EventListener;

/**
 * @Auther:ZouSS
 * @Description:继承监听接口的接口，包含一个事件方法
 * @Date 2020-12-20 17:46
 */
public interface MyListener extends EventListener {
public void MyEvent(MyEvent event);
}
