# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        preNode, locNode = None, head
        while locNode:
            tmp = locNode.next
            locNode.next = preNode
            preNode = locNode
            locNode = tmp
        return preNode
