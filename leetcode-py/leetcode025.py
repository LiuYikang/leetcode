# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def reverseKGroup(self, head, k):
        if head is None or head.next is None:
            return head
        if k == 1:
            return head
        test, testList = 0, head
        while test < k:
            if testList is None:
                return head
            testList = testList.next
            test += 1
        c = 1
        preList, tailList = head, head.next
        head = head.next
        while c < k and head is not None:
            c += 1
            tmp = head.next
            head.next = preList.next
            preList.next = head
            head = tmp
        retList = preList.next 
        tailList.next = preList
        preList.next = self.reverseKGroup(head, k)
        return retList