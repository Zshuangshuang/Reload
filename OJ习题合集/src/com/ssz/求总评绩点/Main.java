package com.ssz.求总评绩点;


import java.util.Scanner;

public class Main {
    private static double gradePoint(int score){
        double ret = 0.0;
        if (score >= 90 && score <= 100){
            ret = 4.0;
        }else if (score >= 85 && score <= 89){
            ret = 3.7;
        }else if (score >= 82 && score <= 84){
            ret = 3.3;
        }else if (score >= 78 && score <= 81){
            ret = 3.0;
        }else if (score >= 75 && score <= 77){
            ret = 2.7;
        }else if (score >= 72 && score <= 74){
            ret = 2.3;
        }else if (score >= 68 && score <= 71){
            ret = 2.0;
        }else if (score >= 64 && score <= 67){
            ret = 1.5;
        }else if (score >= 60 && score <= 63){
            ret = 1.0;
        }else {
            ret = 0;
        }
        return ret;
    }
    private static double totalGPA(int[]credit,int[] score ){
        double total = 0;//总课程的学分绩点
        double oneCourseTotal = 0;
        for (int i = 0; i < credit.length; i++) {
            total += gradePoint(score[i])*credit[i];
            oneCourseTotal += credit[i];
        }
        return total/oneCourseTotal;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int courseNum = scanner.nextInt();
            int[] credit = new int[courseNum];//学分
            int[] score = new int[courseNum];//分数
            for (int i = 0; i < courseNum; i++) {
                credit[i] = scanner.nextInt();
            }
            for (int i = 0; i < courseNum; i++) {
                score[i] = scanner.nextInt();
            }
            System.out.printf("%.2f",totalGPA(credit,score));//保留两位小数
        }
    }
}
