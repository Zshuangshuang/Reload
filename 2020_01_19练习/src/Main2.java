import java.util.Scanner;


public class Main2 {
    public static int getTotalCount(int monthCount){
        int firstMonth = 1;
        int secondMonth = 1;
        int totalRabbits = 1;
        while(monthCount > 2){
            totalRabbits = firstMonth+secondMonth;
            firstMonth = secondMonth;
            secondMonth = totalRabbits;
            monthCount--;
        }
        return totalRabbits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getTotalCount(n));
    }

}
