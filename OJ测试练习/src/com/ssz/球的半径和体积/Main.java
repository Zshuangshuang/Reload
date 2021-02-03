package com.ssz.球的半径和体积;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] array = new  String[6];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.next();
            }
           String[] ret1 = new String[3];
           String[] ret2 = new String[3];
           int sum1 = 0;
           int sum2 = 0;
            for (int i = 0; i < ret1.length; i++) {
                ret1[i] = array[i];
                sum1 = sum1 + Integer.parseInt((ret1[i]))*Integer.parseInt((ret1[i]));
            }

            for (int i = 0; i < ret2.length; i++) {
               ret2[i] = array[i+3];
                sum2 = sum2 + Integer.parseInt((ret2[i]))*Integer.parseInt((ret2[i]));
            }

            double r = Math.sqrt(sum1+sum2);
            double v = r*r*r*4*Math.PI/3;
            System.out.printf("%.3f %.3f",r,v);
        }
    }
}
