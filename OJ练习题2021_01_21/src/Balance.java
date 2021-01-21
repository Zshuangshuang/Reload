import java.util.*;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {

     public int height(TreeNode root){
         if (root == null){
             return 0;
         }
         return Math.max(height(root.left),height(root.right))+1;
     }
     public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null || root.left == null && root.right == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right)) <=1 && isBalance(root.left) && isBalance(root.right);
     }
}