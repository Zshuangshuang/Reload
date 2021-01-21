class Solution {
    public void rotate(int[] nums, int k) {
        int ret = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,ret-1);
       reverse(nums,ret,nums.length-1);
    }
    public void reverse(int[] array,int begin,int end){
        while(begin < end){
            int tmp = array[end];
            array[end] = array[begin];
            array[begin] = tmp;
            begin++;
            end--;
        }

    }

}