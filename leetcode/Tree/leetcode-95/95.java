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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (int m = 0; m < left.size(); m++) {  
                for (int n = 0; n < right.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    res.add(root);
                }
            }
        }
        return res;
    }
}