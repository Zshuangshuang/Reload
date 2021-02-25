package com.zss.根据先序遍历和中序遍历构造二叉树;

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
    //将数组转为list
    private List<Integer> arrayToList(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int e : array){
            list.add(e);
        }
        return list;
    }
    //辅助构建二叉树的方法
   private TreeNode buildTreeHelper(List<Integer> preorderList,List<Integer> inorderList){
        //空树直接返回null
       if (preorderList.size() == 0){
           return null;
       }
       //先序遍历0号位置就是根节点的值
       int rootVal = preorderList.get(0);
       TreeNode root = new TreeNode(rootVal);
       //叶子节点直接返回根节点
       if (preorderList.size() == 1){
           return root;
       }
       //根据中序遍历中根节点的下标计算对应二叉树左子树的长度
       int leftSize = inorderList.indexOf(rootVal);
       //根据先序遍历结果集,得到先序遍历中左子树和右子树对应的部分
       List<Integer> leftPrev = preorderList.subList(1,1+leftSize);
       List<Integer> rightPrev = preorderList.subList(1+leftSize,preorderList.size());
       //根据中序遍历结果集,得到中序遍历左子树和右子树对应的部分
       List<Integer> leftIn = inorderList.subList(0,leftSize);
       List<Integer> rightIn = inorderList.subList(leftSize+1,inorderList.size());
       root.left = buildTreeHelper(leftPrev,leftIn);
       root.right = buildTreeHelper(rightPrev,rightIn);
       return root;
   }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = arrayToList(preorder);
        List<Integer> inorderList = arrayToList(inorder);
        TreeNode root = buildTreeHelper(preorderList,inorderList);
        return root;
    }
}
