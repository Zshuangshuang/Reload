class Solution2 {
    public static boolean isPalindrome(int x) {
        //1、先判断x的"合法性":如果x是负数，肯定不是回文数，如果x是10的倍数，肯定也不是回文数，x==0也不是回文数
        if (x<0 || (x%10 == 0 && x!=0)){
            return false;
        }
        //2、设置一个中间变量ret，作为用来判断是不是回文数的标志
        int ret = 0;
        while(x > ret){
            ret = ret*10 + x%10;
            x = x/10;
        }
        return x==ret || x==ret/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123));
    }
}