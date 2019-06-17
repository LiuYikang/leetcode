package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return head
	}

	l := 0
	p := head
	for p != nil {
		p = p.Next
		l++
	}

	k %= l
	if k == 0 {
		return head
	}

	dummy := &ListNode{0, head}
	q := dummy
	p = head
	for i := 0; i < k; i++ {
		p = p.Next
	}

	for p != nil {
		p = p.Next
		q = q.Next
	}

	dummy.Next = q.Next
	q.Next = nil
	q = dummy.Next
	for q.Next != nil {
		q = q.Next
	}
	q.Next = head

	return dummy.Next

}
