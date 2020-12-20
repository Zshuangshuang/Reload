import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 18:37
 */
public class Test {
    public static void main(String[] args) {
        SelectCourse sc = new SelectCourse();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入最大人数限制");
        sc.setMaxNum(scanner.nextInt());
        sc.addStudent("a");
        sc.addStudent("b");
        sc.addStudent("c");
        sc.addListener(new Listener());
        sc.notifyListener();
    }
}
