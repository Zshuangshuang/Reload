package com.zss.二叉树的分层遍历;


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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return result;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null){
            helper(root.left,level+1);
        }
        if (root.right != null){
            helper(root.right,level+1);
        }
    }
}
