package com.ssz.奇偶校验;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            //将字符串转化为字符数组
            changeJO(str.toCharArray());
        }
    }
    private static void changeJO(char[] ch){
        int[] result = new int[8];
        for (int i = 0; i < ch.length; i++) {
            int n = 0000_0001;
            int j = 7;
            int sum = 0;
            //进行&运算，计算出ch中1的个数
            while(j > 0){
                result[j] = ((ch[i]&n) == 0 ? 0:1);
                if (result[j] == 1){
                    sum++;
                }
                n = n<<1;
                j--;
            }
            if ((sum&1) == 0){
                result[0] = 1;
            }
            for (int k = 0; k < result.length; k++) {
                System.out.print(result[k]);
            }
            result[0] = 0;
            System.out.println();
        }
    }
}
