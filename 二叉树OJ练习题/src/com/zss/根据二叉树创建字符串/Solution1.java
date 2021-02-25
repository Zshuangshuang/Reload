package com.zss.根据二叉树创建字符串;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution1 {

    public String tree2str(TreeNode t) {
      //判断参数的合法性
        if (t == null){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        helper(stringBuilder,t);
        return stringBuilder.toString();
    }

    private void helper(StringBuilder stringBuilder, TreeNode t) {
        //不是空树才进行拼接
        if (t != null){
            stringBuilder.append(t.val);
            //如果是叶子节点直接返回
            if (t.left == null && t.right == null){
                return;
            }else if (t.left != null && t.right == null){
                stringBuilder.append("(");
                helper(stringBuilder,t.left);
                stringBuilder.append(")");
            }else {
                stringBuilder.append("(");
                helper(stringBuilder,t.left);
                stringBuilder.append(")");
                stringBuilder.append("(");
                helper(stringBuilder,t.right);
                stringBuilder.append(")");

            }
        }
    }
}
