#Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param {ListNode[]} lists
    # @return {ListNode}
    def mergeKLists(self, lists):
    	if len(lists) == 0:
    		return []
    	if len(lists) == 1:
    		return lists[0]
    	list1 = lists[0: len(lists) / 2]
    	list2 = lists[len(lists) / 2: len(lists)]
    	head1 = self.mergeKLists(list1)
    	head2 = self.mergeKLists(list2)
    	head = self.mergeTwoLists(head1, head2)
    	return head


    def mergeTwoLists(self, l1, l2):
    	if l1 is None:
    		return l2
    	if l2 is None:
    		return l1
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