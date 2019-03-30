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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> order = new LinkedList<>();
        Queue<TreeNode> reverse = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        order.offer(root);

        while (!order.isEmpty() || !reverse.isEmpty()) {
            List<Integer> tmp1 = new ArrayList<>();
            while (!order.isEmpty()) {
                TreeNode node = order.poll();
                tmp1.add(node.val);
                if (node.left != null) {
                    reverse.offer(node.left);
                }
                if (node.right != null) {
                    reverse.offer(node.right);
                }
            }
            if (tmp1.size() > 0){
                res.add(tmp1);
            }
            
            List<Integer> tmp2 = new ArrayList<>();
            while (!reverse.isEmpty()) {
                TreeNode node = reverse.poll();
                stack.push(node);
                if (node.left != null) {
                    order.offer(node.left);
                }
                if (node.right != null) {
                    order.offer(node.right);
                }
            }
            while (!stack.isEmpty()) {
                tmp2.add(stack.pop().val);
            }
            if (tmp2.size() > 0) {
                res.add(tmp2);
            }
        }
        return res;
    }
}