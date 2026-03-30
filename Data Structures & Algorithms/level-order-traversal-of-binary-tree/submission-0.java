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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            List<Integer> levelAns = new ArrayList<>();
            
            int size = pendingNodes.size();
            for(int i=0; i<size; i++){
                TreeNode front = pendingNodes.poll();
                if(front != null){
                    levelAns.add(front.val);
                    pendingNodes.add(front.left);
                    pendingNodes.add(front.right);
                }
            }
            if(levelAns.size() > 0)
            res.add(levelAns);
        }
        return res;
    }
}
