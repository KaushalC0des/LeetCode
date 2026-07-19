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
     List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) return zigzag;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> Level = new ArrayList<>();
            Stack<Integer> reversestack = new Stack<>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();

                if(flag)
                reversestack.add(node.val);
                else
                Level.add(node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

            }
            flag = !flag;
            while(!reversestack.isEmpty())
            Level.add(reversestack.pop());

            zigzag.add(Level);
        }
        return zigzag;
    }
}