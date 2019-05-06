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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return getRoot(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode getRoot(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int left = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
            left++;
        }
        root.left = getRoot(preorder, preStart + 1, preStart + left, inorder, inStart, inStart + left);
        root.right = getRoot(preorder, preStart + left + 1, preEnd, inorder, inStart + left + 1, inEnd);
        return root;
    }
}