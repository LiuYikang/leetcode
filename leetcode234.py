# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return True
        p, q, mid = head, head, None
        flag = True
        while q.next and q.next.next:
            p, q = p.next, q.next.next
        mid = p.next
        mid = self.reverseList(mid)
        while mid and head:
            if mid.val != head.val:
                flag = False
                break
            mid, head = mid.next, head.next
        mid = self.reverseList(mid)
        p.next = mid
        return flag

    def reverseList(self, head):
        pre, loc = None, head
        while loc:
            tmp = loc.next
            loc.next = pre
            pre = loc
            loc = tmp
        return pre
