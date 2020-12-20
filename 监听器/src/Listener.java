import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 19:02
 */
public class Listener implements MyListener{
    public void MyEvent(MyEvent myEvent){
        if (myEvent.curNum > myEvent.maxNum){
            System.out.println("超出人数限额");
            System.out.println("当前人数为："+myEvent.curNum);
            System.out.println("限额人数为："+myEvent.maxNum);
            System.out.println("请重新设置限额人数：");
            SelectCourse sc = new SelectCourse();
            Scanner scanner = new Scanner(System.in);
            sc.setMaxNum(scanner.nextInt());
        }
    }
}
