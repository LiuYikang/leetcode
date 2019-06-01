package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	newHead := reverseList(head.Next)
	p := newHead
	for p.Next != nil {
		p = p.Next
	}
	p.Next = head
	head.Next = nil
	return newHead
}
