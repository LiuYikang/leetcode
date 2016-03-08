# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        l1, l2 = headA, headB
        while l1 and l2:
            l1, l2 = l1.next, l2.next
        while l1:
            l1 = l1.next
            headA = headA.next
        while l2:
            l2 = l2.next
            headB = headB.next
        start, flag = None, True
        if not headA or not headB:
            return None
        while headA and headB:
            if headA.val == headB.val and flag:
                start = headA
                flag = False
            if headA.val != headB.val:
                print flag
                start = None
                flag = True
            headA, headB = headA.next, headB.next
        return start
