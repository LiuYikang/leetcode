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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        maxPathLocal(root);
        return max;
    }

    private int maxPathLocal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathLocal(root.left);
        int right = maxPathLocal(root.right);
        int res = Math.max(root.val, root.val + Math.max(left, right));
        int localMax = Math.max(res, root.val + left + right);
        max = Math.max(max, localMax);
        return res;
    }
}