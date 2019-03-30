/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Boolean balance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        treeDepth(root);
        return balance;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        int depth = Math.max(left, right) + 1;
        return depth;
    }
}