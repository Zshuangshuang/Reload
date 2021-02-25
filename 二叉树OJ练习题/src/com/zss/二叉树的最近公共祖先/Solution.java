package com.zss.二叉树的最近公共祖先;

public class Solution {
    private boolean search(TreeNode root,TreeNode tmp){
        if (root == null){
            return false;
        }
        if (root == tmp){
            return true;
        }
        //递归判断左子树中是否含有tmp
        if (search(root.left,tmp)){
            return true;
        }
        return search(root.right,tmp);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判断参数的合法性
        if (root == null){
            return null;
        }
        if (p == root || q == root){
            return root;
        }
        //判断p是否在左子树中
        boolean pInLeft = search(root.left,p);
        //判断q是否在左子树中
        boolean qInLeft = search(root.left,q);
        if (pInLeft && qInLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (!pInLeft && !qInLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
