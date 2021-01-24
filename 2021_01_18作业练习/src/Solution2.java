class Solution {
    public static int removeElement(int[] nums, int val) {
      int i = 0;
      int n = nums.length;
      while(i < n){
          if (nums[i] == val){
             nums[i] = nums[n-1];
              n--;
          }else {
              i++;
          }
      }
      return n;
    }

    public static void main(String[] args) {
        int[] array = {3,2,2,3};
        System.out.println(removeElement(array, 3));
    }
}