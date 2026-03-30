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
    public int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        int dfsAns = dfs(root,res);
        return res[0];
    }
    private int dfs(TreeNode root,int[] res){
        if(root == null){
            return 0;
        }
        int leftSum = dfs(root.left,res);
        int rightSum = dfs(root.right,res);
        leftSum = Math.max(leftSum,0);
        rightSum = Math.max(rightSum,0);

        res[0] = Math.max(res[0],root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum,rightSum);
    }

}
