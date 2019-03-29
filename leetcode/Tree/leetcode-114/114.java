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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(0);
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            pre.left = node;
            pre = pre.left;
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.right != null) {
                TreeNode tmp = node.right;
                node.right = null;
                node = tmp;
                while (node != null) {
                    stack.push(node);
                    pre.left = node;
                    pre = pre.left;
                    node = node.left;
                }
            }          
        }

        node = root;
        while (node != null) {
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }
}