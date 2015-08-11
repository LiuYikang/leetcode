# # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# class Solution:
#     # @param {ListNode} head
#     # @return {ListNode}
#     def sortList(self, head):
#     	if not head:
#     		return []
#         return self.fastSort(head)

#     def fastSort(self, head):
#     	if not head or not head.next:
#             return head
#     	leftList = ListNode(0)
#     	rightList = ListNode(0)
#     	tmp, lTmp, rTmp= head.next, leftList, rightList
#     	while(tmp):
#     		if tmp.val < head.val:
#     			lTmp.next, lTmp = tmp, tmp
#     		else:
#     			rTmp.next, rTmp = tmp, tmp
#     		tmp = tmp.next
#     	head.next = self.fastSort(rightList.next)
#     	leftList.next = self.fastSort(leftList.next)
#     	tmp = leftList.next
#     	while not tmp.nex:
#     		tmp = tmp.next
#     	tmp.next = head
#     	return leftList.next

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def sortList(self, head):
        if head == None or head.next == None:
        	return head
        slow = head
        fast = head
        while fast.next and fast.next.next:
        	slow = slow.next
        	fast = fast.next.next
        head1 = head
        head2 = slow.next
        slow.next = None
        head1 = self.sortList(head1)
        head2 = self.sortList(head2)
        head = self.merge(head1, head2)
        return head

    def merge(self, head1, head2):
    	if head1 == None:
    		return head2
    	if head2 == None:
    		return head1
    	mergeList = ListNode(0)
    	p = mergeList
    	while head1 and head2:
    		if head1.val <= head2.val:
    			p.next = head1
    			head1 = head1.next
    			p = p.next
    		else:
    			p.next = head2
    			head2 = head2.next
    			p = p.next
    	if head1 == None:
    		p.next = head2
    	if head2 == None:
    		p.next = head1
    	return mergeList.next