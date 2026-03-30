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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = {k,0};
        inorder(root,count);
        return count[1];
    }
    private void inorder(TreeNode root, int[] count){
        if(root == null){
            return;
        }
        inorder(root.left,count);
        count[0]--;
        if(count[0] == 0){
            count[1] = root.val;
            return;
        }
        inorder(root.right,count);
    }
}
