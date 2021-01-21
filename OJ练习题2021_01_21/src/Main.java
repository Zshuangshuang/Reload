import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();
            }
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            double a4 = 0.0;
            int a5 = 0;
            int tmp = 1;
            boolean flag = false;
            int n = 0;

            for (int i = 0; i < N; i++) {
                //处理a1,能被5整除的偶数
                if (array[i]%5 == 0 && array[i]%2 == 0){
                    a1 += array[i];
                }
                //处理a2,被5除余数为1的数字"求和"
                if (array[i]%5 == 1){
                    flag = true;
                    a2 += array[i]*tmp;
                    tmp = tmp*(-1);
                }
                //处理a3,被5除余数为2的数字的个数
                if (array[i]%5 == 2){
                    a3++;
                }
               //处理a4,被5除余数为3的数字的平均数
                if (array[i]%5 == 3){
                    a4 += array[i];
                    n++;
                }
                //处理a5,被5除余4的最大的数字
                if (array[i]%5 == 4){
                    if (array[i] > a5){
                        a5 = array[i];
                    }
                }
            }
            if (a1 == 0){
                System.out.printf("N"+" ");
            }else {
                System.out.printf(a1+" ");
            }
            if (!flag){
                System.out.printf("N"+" ");
            }else {
                System.out.printf(a2+" ");
            }
            if (a3 == 0){
                System.out.printf("N"+" ");
            }else {
                System.out.printf(a3+" ");
            }
            if (a4 == 0){
                System.out.printf("N"+" ");
            }else {
                System.out.printf(String.format("%.1f",a4/n)+" ");
            }
            if (a5 == 0){
                System.out.printf("N"+" ");
            }else {
                System.out.printf(a5+" ");
            }
        }


    }
}
