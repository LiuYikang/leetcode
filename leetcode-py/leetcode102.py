# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        if not root:
            return res
        queue = collections.deque()
        queue.append(root)
        while queue:
            nextQueue = collections.deque()
            tmpList = []
            while queue:
                tmp = queue.popleft()
                tmpList.append(tmp)
                if tmp.left:
                    nextQueue.append(tmp.left)
                if tmp.right:
                    nextQueue.append(tmp.right)
            queue = nextQueue
            res.append(tmpList)
        return res
