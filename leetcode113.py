# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        allPath = []
        path = []
        self.findPath(root, sum, path, allPath)
        return allPath

    def findPath(self, root, sum, path, allPath):
        if not root:
            return
        sum -= root.val
        path.append(root.val)
        if not root.left and not root.right:
            if sum == 0:
                allPath.append(path[:])
        else:
            if root.left:
                self.findPath(root.left, sum, path, allPath)
            if root.right:
                self.findPath(root.right, sum, path, allPath)
        path.pop()
        return
