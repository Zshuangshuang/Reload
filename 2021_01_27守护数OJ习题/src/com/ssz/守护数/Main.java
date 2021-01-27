package com.ssz.守护数;

import java.util.Scanner;

public class Main {
    private static void isProtectedNum(int num){
        int mul = num*num;
        if (num < 10){
            if ((mul-num)%10 == 0){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }else {
            if ((mul-num) %100 == 0){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            isProtectedNum(num);
        }
    }
}
