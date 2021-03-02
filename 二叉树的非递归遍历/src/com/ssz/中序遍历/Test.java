package com.ssz.中序遍历;

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
    public static void inOrderByLoop(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true){
            //循环往左找,将路径上的元素都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //如果当前栈为空,结束遍历
           if (stack.isEmpty()){
               break;
           }
           //取栈顶元素并访问
           TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            //从当前节点的右子树出发,继续刚才的过程
            cur = top.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = build();
        inOrderByLoop(root);
    }
}
