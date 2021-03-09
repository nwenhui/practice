//https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else {
            targetSum -= root.val;
            if (targetSum == 0) {
                if (root.left == null && root.right == null) {
                    return true;
                }
            }
            boolean left = hasPathSum(root.left, targetSum);
            boolean right = hasPathSum(root.right, targetSum);
            return left || right;
        }
    }
}