# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        ans, path = [], ""
        if not root:
            return ans
        path += str(root.val)
        self.findPath(root, path, ans)
        return ans

    def findPath(self, root, path, allPath):
        if not root.left and not root.right:
            allPath.append(path)
            return
        if root.left:
            self.findPath(root.left, path + "->" + str(root.left.val), allPath)
        if root.right:
            self.findPath(root.right, path + "->" + str(root.right.val), allPath)
        return
