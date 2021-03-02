package com.ssz.根据先序和中序遍历重建二叉树;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    //首先将题目中给的两个数组转化为list

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        List<Integer> preList = arrayToList(pre);
        List<Integer> inList  = arrayToList(in);
        TreeNode root = helper(preList,inList);
        return root;
    }

    private TreeNode helper(List<Integer> preList, List<Integer> inList) {
        //首先判断参数的合法性
        if (preList.size() == 0){
            return null;
        }
        int rootVal = preList.get(0);
        TreeNode root = new TreeNode(rootVal);
        if (preList.size() == 1){
            return root;
        }
        int leftSize = inList.indexOf(rootVal);
        List<Integer> preLeft = preList.subList(1,1+leftSize);
        List<Integer> preRight = preList.subList(1+leftSize,preList.size());

        List<Integer> inLeft = inList.subList(0,leftSize);
        List<Integer> inRight = inList.subList(1+leftSize,inList.size());

        root.left = helper(preLeft,inLeft);
        root.right = helper(preRight,inRight);
        return root;
    }

    private List<Integer> arrayToList(int[] pre) {
        List<Integer> list = new ArrayList<>();
        for (int x : pre){
            list.add(x);
        }
        return list;
    }
}
