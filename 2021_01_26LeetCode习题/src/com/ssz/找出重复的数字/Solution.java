package com.ssz.找出重复的数字;

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
            for (int ret : nums){
                if (map.containsKey(ret)){
                    map.put(ret,map.get(ret)+1);
                }else {
                    map.put(ret,1);
                }
            }
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() >= 2){
                    return entry.getKey();
                }
            }
           return -1;
        }
    }

