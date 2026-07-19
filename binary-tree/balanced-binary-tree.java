/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// math.abs function is used if we want to remove negative sign and want only positive sign 
class Solution {
       public int height(TreeNode root){
        if(root == null){
            return 0;
        } else{
            return 1+Math.max(height(root.left),height(root.right));
        } 
       } 
       public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left)-height(root.right))>1){
            return false;
        }
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        return l&&r;
    }
}