package com.ssz.年会抽奖;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double ret = count(n)/fac(n);
            System.out.printf("%.2f", 100 * ret);
            System.out.println("%");
        }
    }

    public static double count(int n) {
       if (n == 1){
           return 0;
       }
       if (n == 2){
           return 1;
       }
       return (n-1)*(count(n-1)+count(n-2));
    }
    //下面的函数用来求阶乘，得到分母
    public static double fac(int n){
        if (n == 0){
            return 1;
        }
        return n*fac(n-1);
    }
}
