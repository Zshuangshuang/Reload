import java.util.Arrays;

class Solution {
    public static void rotate(int[] nums, int k) {
       /*int n = nums.length;
       int[] newArray = new int[n];
        for (int i = 0; i < newArray.length; i++) {
            newArray[(i+k)%n] = nums[i];
        }
        System.arraycopy(newArray,0,nums,0,n);*/
        int ret = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,ret-1);
        reverse(nums,ret,nums.length-1);
    }
    private static void reverse(int[] nums,int begin,int end){
        while(begin < end){
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums,2);
        System.out.println(Arrays.toString(nums));
    }
}