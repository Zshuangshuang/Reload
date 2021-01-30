package com.ssz.青蛙跳台阶;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-30 22:09
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        int t1 = 1;
        int t2 = 2;
        int t3 = 0;
        for (int i = 3; i <= target; i++) {
            t3 = t1+t2;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }
}
