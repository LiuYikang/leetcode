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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return getRoot(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode getRoot(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int left = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                break;
            }
            left++;
        }
        root.left = getRoot(inorder, inStart, inStart + left - 1, postorder, postStart, postStart + left - 1);
        root.right = getRoot(inorder, inStart + left + 1, inEnd, postorder, postStart + left, postEnd - 1);
        return root;
    }
}