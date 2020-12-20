import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:监听器实现的功能，判断event.maxNum和event.curNum的关系
 * @Date 2020-12-20 17:45
 */
public class Listener implements MyListener{

    @Override
    public void MyEvent(MyEvent event) {
        if (event.curNum > event.maxNum){
            System.out.println("人数超过限额人数");
            System.out.println("当前人数为："+event.curNum);
            System.out.println("最大人数为："+event.maxNum);
            System.out.println("请重新设置限额人数：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            SelectCourse sc = new SelectCourse();
            sc.setMaxNum(num);
        }
    }
}
