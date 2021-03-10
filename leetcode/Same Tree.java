//https://leetcode.com/problems/same-tree/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return checkChildren(p.right, q.right) && checkChildren(p.left, q.left);
    }
    
    boolean checkChildren(TreeNode child_p, TreeNode child_q) {
        if (child_p == null && child_q == null) {
            return true;
        }
        if (child_p == null || child_q == null) {
            return false;
        }
        if (child_p.val != child_q.val) {
            return false;
        }
        if (!checkChildren(child_p.left, child_q.left)) {
            return false;
        }
        if (!checkChildren(child_p.right, child_q.right)) {
            return false;
        }
        return true;
    }
}