package com.zss.二叉树的最近公共祖先;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution1 {
    private TreeNode lca = null;
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;
        int right = findNode(root.right,p,q)?1:0;
        int mid = (root == p || root == q)?1:0;
        if (left+right+mid == 2){
            lca = root;
        }
        return (left+right+mid)>0;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }


}
