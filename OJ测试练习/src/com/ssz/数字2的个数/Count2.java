package com.ssz.数字2的个数;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-01 22:07
 */
import java.util.*;
public class Count2 {
    public int count(int n) {
        // write code here
        int number =0;
        while(n!=0){
            if(n %10 == 2){
                number++;
            }

            n = n/10;
        }
        return number;
    }
    public int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count(i);
            count += count(i);
        }
        return count;
    }

}

