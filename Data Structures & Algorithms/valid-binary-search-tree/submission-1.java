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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!(root.val > max(root.left) && root.val < min(root.right))){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
    public int max(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        while(root.right != null){
           root = root.right;
        }
        return root.val;
    }
    public int min(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
