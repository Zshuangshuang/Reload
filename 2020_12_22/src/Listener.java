import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:10
 */
public class Listener implements MyListener {
    @Override
    public void MyEvent(MyEvent event) {
        if (event.curNum > event.maxNum){
            System.out.println("已超过最大人数限额");
            System.out.println("当前人数为："+event.curNum);
            System.out.println("最大人数限额为："+event.maxNum);
            System.out.println("请重新设置最大人数");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            SelectSource s = new SelectSource();
            s.setMaxNum(n);
        }
    }
}
