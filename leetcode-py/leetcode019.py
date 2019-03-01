# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @param {integer} n
    # @return {ListNode}
    def removeNthFromEnd(self, head, n):
    	nHead = ListNode(0)
    	nHead.next = head
    	p = head
    	i = 0
    	while i < n:
    		p = p.next
    		i += 1
    	pre = nHead
    	while p:
    		p = p.next
    		pre = pre.next
    	pre.next = pre.next.next
    	return nHead.next