package com.ssz.查找和最小的k对数字;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    private int n1;
    private int n2;
    private int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = this.n1+this.n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair o) {
        return this.sum-o.sum;
    }
}
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
       //判断参数的合法性
        if (nums1.length == 0 || nums2.length == 0 || k <= 0){
            return result;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        //将nums1,nums2中的数对均放入优先队列当中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i],nums2[j]));
            }
        }
        //取出前k对小的数对,放入结果集当中
        for (int i = 0; i < k && !queue.isEmpty() ; i++) {
            Pair pair = queue.poll();
            List<Integer> ret = new ArrayList<>();
            ret.add(pair.getN1());
            ret.add(pair.getN2());
            result.add(ret);
        }
        return result;
    }
}
