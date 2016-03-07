# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def checkTree(self, lNode, rNode):
        if not lNode and not rNode:
            return True
        if not lNode or not rNode:
            return False
        lFlag = self.checkTree(lNode.left, rNode.right)
        rFlag = self.checkTree(rNode.left, lNode.right)
        if not (lFlag and rFlag):
            return False
        return lNode.val == rNode.val

    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        return self.checkTree(root.left, root.right)
