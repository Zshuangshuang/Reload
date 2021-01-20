import java.util.Scanner;


public class Solution3 {
    public static boolean isPalindrome(int x) {
        if (x <0 || x%10==0 && x!=0){
            return false;
        }
        int ret = 0;
        while(x > ret){
            ret = ret*10+x%10;
            x = x/10;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(isPalindrome(x));
    }
}
