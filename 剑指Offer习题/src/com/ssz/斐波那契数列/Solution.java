package com.ssz.斐波那契数列;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-30 22:07
 */
public class Solution {
    public  int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
