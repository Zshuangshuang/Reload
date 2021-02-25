package com.zss.二叉搜索树与双向链表;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
      if (pRootOfTree == null){
          return null;
      }
      if (pRootOfTree.left == null && pRootOfTree.right == null){
          return pRootOfTree;
      }
      TreeNode left = Convert(pRootOfTree.left);
      TreeNode leftTail = left;
      //找到左子树的尾巴节点
        while (left != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //如果左子树非空,则将左子树的尾巴节点和根节点拼接起来
        if (left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        //如果右子树非空，则将根节点和右子树拼接起来
        if (right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return (left==null)?pRootOfTree:left;
    }
}
