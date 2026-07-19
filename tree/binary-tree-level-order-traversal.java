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
 // here double list is used too efficiently manage the nodes that need to be proceed . visit all the node at one level , before moving to the next . this is very important 
 // we can also offer in place of add


 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
         if (root == null) {
            return result; 
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> curr=new ArrayList<>();int size=q.size();
            for(int i=0;i<size;i++){
            TreeNode currNode=q.poll();
            if(currNode!=null){
                curr.add(currNode.val);
                if(currNode.left!=null) q.add(currNode.left);
              
                if(currNode.right!=null) q.add(currNode.right);
            }
            
        }               result.add(curr);

    }return result;
}
}
