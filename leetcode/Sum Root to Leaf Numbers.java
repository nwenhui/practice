//https://leetcode.com/problems/sum-root-to-leaf-numbers/

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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) {
            getSum(root, 0);
        }
        return sum;
    }
    
    void getSum(TreeNode root, int num) {
        if (root.right == null && root.left == null) {
            sum += (num * 10) + root.val;
            return;
        }
        if (root.right != null) {
            getSum(root.right, (num * 10) + root.val);
        }
        if (root.left != null) {
            getSum(root.left, (num * 10) + root.val);
        }
    }
}
