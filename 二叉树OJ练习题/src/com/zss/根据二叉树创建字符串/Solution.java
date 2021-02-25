package com.zss.根据二叉树创建字符串;


public class Solution {
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }
        help(t);
        //将多余的()删掉
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private void help(TreeNode t) {
        if (t == null){
            return;
        }
        //直接根据先序遍历的结果进行拼接
        stringBuilder.append("(");
        stringBuilder.append(t.val);
        help(t.left);
        if (t.left == null && t.right != null){
            stringBuilder.append("()");
        }
        help(t.right);
        stringBuilder.append(")");
    }
}
