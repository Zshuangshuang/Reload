package com.ssz.人民币;

import java.util.Scanner;



public class Main{
    private static final char[] NUM = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '拾',
            '佰', '仟', '万', '亿'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        System.out.println(exchange(money));
    }
    public static String exchange(double money){
        long tmp = (long)money;
        StringBuilder stringBuilder = new StringBuilder("人民币");
        if (tmp > 0){
            exchange(money,stringBuilder);
            stringBuilder.append('元');
        }
        int v = (int) (money * 100 - tmp * 100 + 0.0001);
        int i = v / 10;
        int j = v % 10;
        if (i == 0 && j == 0) {
            stringBuilder.append('整');

            return stringBuilder.toString();
        }
        if (i != 0) {
            stringBuilder.append(NUM[i]).append('角');
        }

        if (j != 0) {
            stringBuilder.append(NUM[j]).append('分');
        }


        return stringBuilder.toString();
    }
    public static void exchange(double n,StringBuilder stringBuilder) {
        if (n >= 1_0000_0000) {
            double q = n / 1_0000_0000;
            double r = n % 1_0000_0000;

            exchange(q,stringBuilder);
            stringBuilder.append('亿');

            // 是亿的整数倍
            if (r != 0) {
                exchange(r, stringBuilder);
            }
        }
        // 大于一万
        else if (n >= 1_0000) {
            double q = n / 1_0000;
            double r = n % 1_0000;

            exchange(q, stringBuilder);
            stringBuilder.append('万');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 100) {
                    stringBuilder.append('零');
                }

                exchange(r, stringBuilder);
            }
        }
        // 大于一千
        else if (n >= 1000) {
            double q = n / 1000;
            double r = n % 1000;

            exchange(q, stringBuilder);
            stringBuilder.append('仟');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 100) {
                    stringBuilder.append('零');
                }

                exchange(r, stringBuilder);
            }
        }
        // 大于一百
        else if (n >= 100) {
            double q = n / 100;
            double r = n % 100;

            exchange(q, stringBuilder);
            stringBuilder.append('佰');

            // 是亿的整数倍
            if (r != 0) {

                if (r < 10) {
                    stringBuilder.append('零');
                }

                exchange(r, stringBuilder);
            }
        }
        // 大于十
        else if (n >= 10) {
            double q = n / 10;
            double r = n % 10;

            if (q > 1) {
                exchange(q, stringBuilder);
            }
            stringBuilder.append('拾');

            // 是亿的整数倍
            if (r != 0) {
                exchange(r, stringBuilder);
            }

        } else {
            stringBuilder.append(NUM[(int) n]);
        }

    }
}