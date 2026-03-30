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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    TreeNode helper(int[] pre, int[] in, int pstart, int pend, int instart, int inend){
        if(instart > inend){
            return null;
        }
        TreeNode root = new TreeNode(pre[pstart]);
        int i=0;
        for(i = instart; i<=inend; i++){
            if(in[i] == root.val) break;
        }
        int leftLen = i - instart;
        root.left = helper(pre,in,pstart+1,pstart+leftLen,instart,i-1);
        root.right = helper(pre,in,pstart+1+leftLen,pend,i+1,inend);
        return root;

    }
}
