# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        ans = root
        while True:
            if p.val > ans.val and q.val > ans.val:
                ans = ans.right
            elif p.val < ans.val and q.val < ans.val:
                ans = ans.left
            else:
                break
        return ans
