package com.ssz.找零钱;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] str1 = scanner.next().split("[.]");
      String[] str2 = scanner.next().split("[.]");
      //将它们换成最小的Kunt
      int ret1 = (Integer.valueOf(str1[0])*17+Integer.valueOf(str1[1]))*29+Integer.valueOf(str1[2]);
      int ret2 = (Integer.valueOf(str2[0])*17+Integer.valueOf(str2[1]))*29+Integer.valueOf(str2[2]);
      int tmp = ret2-ret1;
      int f1 = tmp % 29;
      int f2 = tmp / 29 % 17;
      int f3 = tmp / 29 /17;
      System.out.print(f3+"."+Math.abs(f2)+"."+Math.abs(f1));
    }
}

