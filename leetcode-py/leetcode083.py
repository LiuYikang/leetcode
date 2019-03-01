# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        p1, p2 = head, head.next
        while p2:
            if p2.val != p1.val:
                p1.next, p1 = p2, p1.next
            else:
                p1.next = None
            p2 = p2.next
        return head
