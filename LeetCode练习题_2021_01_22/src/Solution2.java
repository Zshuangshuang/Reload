
public class Solution {
    public int[] sortedSquares(int[] nums) {
        //采用双指针法(类似于归并排序)
        //先找到负数部分的下标
        int neg = -1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0){
                neg = i;
            }else {
                break;
            }
        }
        int index = 0;
        int fNum = neg;
        int zNum = neg+1;
        int[] result = new int[len];
        while(fNum >= 0 || zNum < len){
            if (fNum < 0){
                result[index] = nums[zNum]*nums[zNum];
                zNum++;
            }else if (zNum == len){
                result[index] = nums[fNum]*nums[fNum];
                fNum--;
            }else if (nums[zNum]*nums[zNum] > nums[fNum]*nums[fNum]){
                result[index] = nums[fNum]*nums[fNum];
                fNum--;
            }else {
                result[index] = nums[zNum]*nums[zNum];
                zNum++;
            }
            index++;
        }
        return result;

    }


}
