# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root:
            return False
        if sum - root.val == 0 and not root.left and not root.right:
            return True
        return self.hasPathSum(root.left, sum-root.val) or self.hasPathSum(root.right, sum-root.val)

    def hasPathSum1(self, root, sum):
        if not root:
            return False
        stack = []
        sums = []
        stack.append(root)
        sums.append(0)
        while stack:
            tmp = stack.pop()
            tmpSum = sums.pop() + tmp.val
            if not tmp.left and not tmp.right and tmpSum == sum:
                return True
            if tmp.left:
                stack.append(tmp.left)
                sums.append(tmpSum)
            if tmp.right:
                stack.append(tmp.right)
                sums.append(tmpSum)
        return False
