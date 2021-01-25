import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int sum1 = 0;
            int sum2 = 0;
            int n = num;
            int m = num*num;
            while(n != 0){
                sum1 += n%10;
                n = n/10;
            }
            while(m != 0){
                sum2 += m%10;
                m = m/10;
            }
            System.out.println(sum1+" "+sum2);
        }

    }
}
