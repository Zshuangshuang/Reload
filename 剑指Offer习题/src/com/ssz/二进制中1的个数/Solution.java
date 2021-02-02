package com.ssz.二进制中1的个数;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-02 22:02
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
