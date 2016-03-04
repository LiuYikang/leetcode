# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import collections


class Solution(object):
    def maxDepth1(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root.left and not root.right:
            return 1
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        queue = collections.deque()
        dep = 0
        queue.append(root)
        while not queue:
            nextQueue = collections.deque()
            while not queue:
                tmp = queue.popleft()
                if not tmp.left:
                    nextQueue.append(tmp.left)
                if not tmp.right:
                    nextQueue.append(tmp.right)
            queue = nextQueue
            dep += 1
        return dep
