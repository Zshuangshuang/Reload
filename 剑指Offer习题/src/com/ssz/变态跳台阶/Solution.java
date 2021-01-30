package com.ssz.变态跳台阶;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-30 22:17
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        return (int)Math.pow(2,target-1);
    }
}