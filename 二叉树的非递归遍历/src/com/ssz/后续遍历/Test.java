package com.ssz.后续遍历;

import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test {
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
    public static void postOrderByLoop(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                return;
            }
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right){
                System.out.print(top.val+" ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = build();
        postOrderByLoop(root);
    }
}
