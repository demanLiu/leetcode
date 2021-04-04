/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int max = 0;

    /**
     * 以root为根的最大路径是 maxLengthRight+ maxLengthLeft;
     * 
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getPath(root);
        return max;
    }

    private int getPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getPath(root.left);
        int right = getPath(root.right);
        int leftVal = 0;
        int rightVal = 0;
        if (root.left != null && root.left.val == root.val) {
            leftVal = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightVal = right + 1;
        }
        max = Math.max(max, leftVal + rightVal);
        return Math.max(leftVal, rightVal);

    }
}
// @lc code=end
