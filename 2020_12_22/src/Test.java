import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 17:57
 */
public class Test {

    public static void main(String[] args) {
        SelectSource sc = new SelectSource();
        sc.addStudent("a");
        sc.addStudent("b");
        System.out.println("请输入最大人数");
        Scanner scanner = new Scanner(System.in);
        int maxNum = scanner.nextInt();
        sc.setMaxNum(maxNum);
        sc.addListener(new Listener());
        sc.notifyListener();
    }
}
