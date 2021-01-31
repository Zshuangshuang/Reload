package com.ssz.单调栈结构;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //TODO
    private static void findMinS(int[] array){
        if (array == null || array.length == 0){
            System.out.println("-1"+" "+"-1");
        }
        List list = new ArrayList();
        for (int x : array){
            list.add(x);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

        }
    }
}
