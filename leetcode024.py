# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def swapPairs(self, head):
        if head is None or head.next is None:
            return head
        node1, node2 = head, head.next
        if node2.next is not None:
            subHead = node2.next
            node2.next = node1
            node1.next = self.swapPairs(subHead)
        else:
            node2.next = node1
            node1.next = None
        return node2