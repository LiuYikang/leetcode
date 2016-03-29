# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head:
            return None
        preRotate = ListNode(0)
        tmp, rotateHead, preRotate.next = head, head, head
        l = 1
        while tmp.next:
            l, tmp = l+1, tmp.next
        i = 1
        k = k if k < l else k%l
        if k == 0:
            return head
        tmp = head
        while i < k:
            tmp = tmp.next
            i += 1
        while tmp.next:
            rotateHead, tmp = rotateHead.next, tmp.next
            preRotate = preRotate.next
        preRotate.next = None
        rotateEnd = rotateHead
        while rotateEnd.next:
            rotateEnd = rotateEnd.next
        rotateEnd.next = head
        return rotateHead
       