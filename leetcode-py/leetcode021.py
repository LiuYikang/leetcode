# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def mergeTwoLists(self, l1, l2):
    	head = ListNode(0)
    	tmp = head
    	while l1 is not None and l2 is not None:
    		if l1.val <= l2.val:
    			tmp.next, tmp = l1, l1
    			l1 = l1.next
    		else:
    			tmp.next, tmp = l2, l2
    			l2 = l2.next
    	if l1 is not None:
    		tmp.next = l1
    	if l2 is not None:
    		tmp.next = l2
    	return head.next