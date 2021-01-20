class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0;
    int p2 = 0;
    int[] sort = new int[m+n];
    int cur;
    while(p1 < m || p2 < n){
      if (p1 == m){
        cur = nums2[p2++];
      }else if (p2 == n){
        cur = nums1[p1++];
      }else if (nums1[p1] < nums2[p2]){
        cur = nums1[p1++];
      }else {
        cur = nums2[p2++];
      }
      sort[p1+p2-1] = cur;
    }
    for (int i = 0; i < m+n; i++) {
      nums1[i] = sort[i];
    }
  }
}

