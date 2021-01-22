import java.util.Scanner;

public class Main1 {
    public static int getMax(int c,int cur){
        int tmp = c%cur;
        while(tmp != 0){
            c = cur;
            cur = tmp;
            tmp = c%cur;
        }
        return cur;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int b = scanner.nextInt();
                if (b <= a){
                    a += b;
                }else {
                    a = a+getMax(a,b);
                }
            }
            System.out.println(a);
        }
    }
}
