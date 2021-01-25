package com.com.ssz.返回第三大的数字;

import java.util.TreeSet;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-24 14:35
 */
public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0 || nums == null){
            System.exit(-1);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer i : nums){
            set.add(i);
            if (set.size() > 3){
                set.remove(set.first());
            }
        }
        return set.size()>=3 ? set.first() : set.last();
    }
}
