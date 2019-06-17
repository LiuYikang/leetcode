package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	if head == nil {
		return head
	}

	dummy1 := &ListNode{0, nil}
	dummy2 := &ListNode{0, nil}
	p1, p2 := dummy1, dummy2

	p := head
	for p != nil {
		if p.Val < x {
			p1.Next = p
			p1 = p1.Next
		} else {
			p2.Next = p
			p2 = p2.Next
		}
		p = p.Next
	}
	p1.Next = dummy2.Next
	p2.Next = nil
	return dummy1.Next
}
