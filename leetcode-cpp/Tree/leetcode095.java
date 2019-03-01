/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
        {
            List<TreeNode> list = Collections.emptyList();
            return list;
        }
        return BST(1, n);
    }
    
    public List<TreeNode> BST(int start, int end)
    {
        List<TreeNode> BSTList = new ArrayList<TreeNode>();
        
        if(start > end)
        {
            BSTList.add(null);
            return BSTList;
        }
        
        if(start == end)
        {
            BSTList.add(new TreeNode(start));
            return BSTList;
        }
        
        List<TreeNode> leftList, rightList;
        for(int i = start; i <= end; i++)
        {
            leftList = BST(start, i - 1);
            rightList = BST(i + 1, end);
            
            for(TreeNode rnode : rightList)
            {
                for(TreeNode lnode : leftList)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    BSTList.add(root);
                }
            }
        }
        return BSTList;
    }
}