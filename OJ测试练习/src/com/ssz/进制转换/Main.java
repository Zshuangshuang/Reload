package com.ssz.进制转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next().substring(2);
            int n = Integer.parseInt(str,16);
            System.out.println(n);
        }
    }
}
