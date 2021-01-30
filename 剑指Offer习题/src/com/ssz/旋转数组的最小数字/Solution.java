package com.ssz.旋转数组的最小数字;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-30 21:46
 */
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //判断参数的合法性
        if (array == null || array.length == 0){
            return 0;
        }
       int minNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= minNum){
                minNum = array[i];
            }
        }
        return minNum;
    }
}