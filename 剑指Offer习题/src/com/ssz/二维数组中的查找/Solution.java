package com.ssz.二维数组中的查找;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-29 13:32
 */
public class Solution{
    public boolean Find(int target, int [][] array) {
        //计算二维数组的行数
        int cols = array.length;
        //判断参数的合法性
        if(cols == 0){
            return false;
        }
        //计算二维数组的列数
        int rows = array[0].length;
        if (rows == 0){
            return false;
        }
        //找到左下角元素的坐标位置
        int col = cols-1;
        int row = 0;
        while(col >= 0 && row<rows ){
            if (array[col][row] < target){
                row++;
            }else if (array[col][row] == target){
                return true;
            }else {
                col--;
            }
        }
        return false;
    }
}
