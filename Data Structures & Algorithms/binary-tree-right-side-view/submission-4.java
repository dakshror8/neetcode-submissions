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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            TreeNode front = pendingNodes.peek();
            int size = pendingNodes.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                front = pendingNodes.poll();
                if(front != null){
                    pendingNodes.add(front.left);
                    pendingNodes.add(front.right);
                    level.add(front.val);
                }
            }
            if(level.size() > 0)
            res.add(level.get(level.size()-1));
        }    
        return res;
    }
    
}
