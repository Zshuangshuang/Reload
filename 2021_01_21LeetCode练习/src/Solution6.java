
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[(i+k) % len] = nums[i];
        }
        System.arraycopy(newArray,0,nums,0,len);
    }

}