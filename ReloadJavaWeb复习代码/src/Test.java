import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 17:47
 */
public class Test {
    public static void main(String[] args) {
        SelectCourse sc = new SelectCourse("操作系统");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入限额人数：");
        int max = scanner.nextInt();
        sc.setMaxNum(max);
        sc.addStudent("张三");
        sc.addStudent("李四");
        sc.addStudent("王五");
        sc.addListener(new Listener());
        sc.notifyListener();
    }
}
