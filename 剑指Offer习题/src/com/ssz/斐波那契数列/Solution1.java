package com.ssz.斐波那契数列;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-30 21:58
 */
public class Solution1 {
    public  int Fibonacci(int n) {
        if ( n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

}