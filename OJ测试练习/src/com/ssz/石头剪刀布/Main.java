package com.ssz.石头剪刀布;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] jia = new int[3];
        int[] yi = new int[3];
        int jiaWin = 0;
        int yiWin = 0;
        for (int i = 0; i < n; i++) {
            char A = scanner.next().charAt(0);
            char B = scanner.next().charAt(0);
            if (A == 'B' && B == 'C'){
                jiaWin++;
                jia[0]++;
            }else if(A == 'C' && B == 'J'){
                jiaWin++;
                jia[1]++;
            }else if(A == 'J' && B == 'B'){
                jiaWin++;
                jia[2]++;
            }else if (A == 'C' && B == 'B'){
                yiWin++;
                yi[0]++;
            }else if (A == 'J' && B == 'C'){
                yiWin++;
                yi[1]++;
            }else if (A == 'B' && B == 'J'){
                yiWin++;
                yi[2]++;
            }
        }
        System.out.println(jiaWin+" "+(n-jiaWin-yiWin)+" "+yiWin);
        System.out.println(yiWin+" "+(n-jiaWin-yiWin)+" "+jiaWin);
        if (jia[0] >= jia[1] && jia[0] >= jia[2] ){
            System.out.print('B');
        }else if (jia[1] >= jia[2]){
            System.out.print('C');
        }else {
            System.out.print('J');
        }
        System.out.print(" ");
        if (yi[0] >= yi[1] && yi[0] >= yi[2] ){
            System.out.print('B');
        }else if (yi[1] >= yi[2]){
            System.out.print('C');
        }else {
            System.out.print('J');
        }
    }
}
