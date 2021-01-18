class Solution3 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if (target > nums[mid]){
                left = mid+1;
            }else if (nums[mid] == target){
                return mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        int ret = searchInsert(array,2);
        System.out.println(ret);
    }
}