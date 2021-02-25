package com.zss.二叉树的构建和遍历;

import java.util.Scanner;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class Main {

    public static void main(String[] args) {
        //处理多行输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }
    private static int index;
    private static TreeNode build(String line) {
        index = 0;
        return createPrevOrder(line);
    }

    private static TreeNode createPrevOrder(String line) {
        char cur = line.charAt(index);
        if (cur == '#'){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = createPrevOrder(line);
        root.right = createPrevOrder(line);
        return root;
    }

    private static void inOrder(TreeNode root) {
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
