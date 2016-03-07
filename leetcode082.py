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
        nhead = ListNode(0)
        nhead.next, p = head, nhead
        flag = False
        while p:
            if p.next and p.next.next and (p.next.val == p.next.next.val):
                p.next = p.next.next
                flag = True
            elif flag and p.next:
                    p.next = p.next.next
                    flag = False
            else:
                p = p.next
        return nhead.next
