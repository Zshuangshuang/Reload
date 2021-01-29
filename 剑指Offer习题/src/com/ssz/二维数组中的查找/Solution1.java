package com.ssz.二维数组中的查找;

public class Solution1 {
    public boolean Find(int target, int [][] array) {
        for (int col = 0; col < array.length; col++) {
            for (int row = 0; row < array[0].length; row++) {
                if (array[col][row] == target){
                    return true;
                }
            }
        }
        return false;
    }
}