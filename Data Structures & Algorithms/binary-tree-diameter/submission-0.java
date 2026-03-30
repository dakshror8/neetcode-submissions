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
    class Pair{
        int first; // diameter
        int second; // height
        Pair(int a,int b){
            first = a;
            second = b;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = diameterHeight(root);
        return res.first;
    }
    private Pair diameterHeight(TreeNode root){
        if(root == null){
            Pair p = new Pair(0,0);
            return p;
        }
        Pair leftPair = diameterHeight(root.left);
        Pair rightPair = diameterHeight(root.right);
        int height = 1 + Math.max(leftPair.second,rightPair.second);
        int option1 = leftPair.second + rightPair.second;
        int option2 = leftPair.first;
        int option3 = rightPair.first;
        int diameter = Math.max(option1,Math.max(option2,option3));
        Pair res = new Pair(diameter,height);
        return res;
    }
}
