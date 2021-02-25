package com.zss.根据后续和中序遍历构造二叉树;



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
    private List<Integer> arrayToList(int[] array){
        List<Integer> list = new ArrayList<>();
        for (int e : array){
            list.add(e);
        }
        return list;
    }
    private TreeNode buildTreeHelper(List<Integer> inorderList,List<Integer> postorderList){
        if (inorderList.size() == 0){
            return null;
        }
        if (inorderList.size() == 1){
          TreeNode node = new TreeNode(inorderList.get(0));
          return node;
        }
        int rootVal = inorderList.get(1);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = inorderList.indexOf(rootVal);
        List<Integer> leftIn = inorderList.subList(0,leftSize+1);
        List<Integer> rightIn = inorderList.subList(leftSize+1,inorderList.size());
        List<Integer> leftPost = postorderList.subList(0,leftSize+1);
        List<Integer> rightPost = postorderList.subList(leftSize+1,postorderList.size()-leftSize-1);
        root.left = buildTreeHelper(leftIn,leftPost);
        root.right = buildTreeHelper(rightIn,rightPost);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            List<Integer> inorderList = arrayToList(inorder);
            List<Integer> postorderList = arrayToList(postorder);
            TreeNode root = buildTreeHelper(inorderList,postorderList);
            return root;
    }
}
