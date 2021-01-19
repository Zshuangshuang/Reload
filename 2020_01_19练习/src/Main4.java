import java.util.Scanner;


public class Main4 {
    //递归写法
    public static int getTotalCount(int monthCount) {

        if (monthCount < 3){
            return 1;
        }
        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getTotalCount(n));
    }

}
