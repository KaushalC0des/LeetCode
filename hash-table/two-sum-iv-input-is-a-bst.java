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
class Solution {
    private Set<Integer> seen;
    public boolean findTarget(TreeNode root, int k) {
        seen = new HashSet<>();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode node , int k){
        if(node == null){
            return false;
        }

        int complement = k - node.val;
        if(seen.contains(complement)) {
            return true;
        }

        seen.add(node.val);
        
        return dfs(node.left, k) || dfs(node.right, k);
    }
}