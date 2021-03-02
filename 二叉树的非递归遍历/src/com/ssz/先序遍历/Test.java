package com.ssz.先序遍历;

import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test{
    public static TreeNode build(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        b.left = d;
        d.right = e;
        a.right = c;
        c.right = f;
        return a;
    }
    public static void prevOrderByLoop(TreeNode root){
        //判断是不是空树
        if (root == null){
            return;
        }
        //将根节点入栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //循环取栈顶元素
            TreeNode top = stack.pop();
            //访问当前元素
            System.out.print(top.val+" ");
            //将右子树和左子树分别入栈
            if (top.right != null){
                stack.push(top.right);
            }
            if (top.left != null){
                stack.push(top.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = build();
        prevOrderByLoop(root);
    }
}
