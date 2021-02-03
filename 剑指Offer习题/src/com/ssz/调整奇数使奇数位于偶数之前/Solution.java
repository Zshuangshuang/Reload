package com.ssz.调整奇数使奇数位于偶数之前;



public class Solution {
    public  void reOrderArray(int [] array) {
        int len = array.length;
        int ret = 0;//用来记录数组中已经放好的奇数的位置
        for (int i = 0; i < len; i++) {
            if ((array[i]%2) == 1){
                int cur = i;
                while(cur > ret){
                    int tmp = array[cur];
                    array[cur] = array[cur-1];
                    array[cur-1] = tmp;
                    cur--;
                }
                ret++;
            }
        }
    }


}
