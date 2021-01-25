package com.ssz.寻找数组的中心索引;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums){
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum-leftSum-nums[i]){
                return i;
            }else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}