public class Solution {
    public boolean Find(int target, int [][] array) {
        //(1)先计算出二维数组的行数和列数，并判断合法性
        int rows = array.length;
        if (rows == 0){
            return false;
        }
        int cols = array[0].length;
        if (cols == 0){
            return false;
        }
        //(2)找到左下角的元素
        int row = rows-1;
        int col = 0;
        //(3)判断左下角元素和target的大小关系，并作出相应的调整
        while(row >= 0 && col < cols){
            if (target > array[row][col]){
                col++;
            }else if (target == array[row][col]){
                return true;
            }else {
                row--;
            }
        }
        return false;
    }
}