//https://leetcode.com/problems/binary-tree-paths/

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
    List<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            getPath(root, "");
        }
        return result;
    }
    void getPath(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            path += root.val;
            result.add(path);
            return;
        }
        if (root.left != null) {
            getPath(root.left, path + root.val + "->");
        }
        if (root.right != null) {
            getPath(root.right, path + root.val + "->");
        }
    }
}