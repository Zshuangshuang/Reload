package com.ssz.大整数排序;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            BigInteger[] bigNum = new BigInteger[num];
            for (int i = 0; i < num; i++) {
                bigNum[i] = scanner.nextBigInteger();
            }
            Arrays.sort(bigNum);
            for (int i = 0; i < num; i++) {
                System.out.println(bigNum[i]);
            }
        }
    }
}
