/**
 * 给定一个数组，将数组中的元素向右移动 `k` 个位置，其中 `k` 是非负数。
 * */
class Solution {
    public void reverse(int[] nums,int begin,int end){
        while(begin < end){
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }
  public void rotate(int[] nums, int k) {
        int n = nums.length;
        int ret = k%n;
    reverse(nums,0,n-1);
    reverse(nums,0,ret-1);
    reverse(nums,ret,n-1);
 }
    
    
}