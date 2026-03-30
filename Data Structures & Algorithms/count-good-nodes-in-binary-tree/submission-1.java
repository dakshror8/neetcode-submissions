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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,Integer.MIN_VALUE);
    }
    int goodNodesHelper(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        
        int l = goodNodesHelper(root.left, Math.max(max,root.val));
        int r = goodNodesHelper(root.right,Math.max(max,root.val));
        if(root.val >= max){
            return 1 + l + r;
        }
        else{
            return l+r;
        }
    }
}
