package com.ssz.按奇偶排序;

class Solution1 {
    public void swap(int[] array,int x,int y){
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right  = A.length-1;
        while(left < right){
            while((left < right) && (A[left]%2 == 0)){
                left++;
            }
            while((left<right) && (A[right]%2 != 0)){
                right--;
            }
            swap(A,left,right);
        }
        return A;
    }
}