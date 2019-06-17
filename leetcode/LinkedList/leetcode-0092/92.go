package linkedlist

// ListNoe Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	if head == nil || m == n {
		return head
	}
	l := n - m + 1
	dummy := &ListNode{0, head}
	pre, p := dummy, head

	for i := 1; i < m; i++ {
		pre = p
		p = p.Next
	}
	last := p

	post := p
	for i := 0; i <= n; i++ {
		post = post.Next
	}

	for i := 0; i < l; i++ {
		tmp := p.Next
		p.Next = pre.Next
		pre.Next = p
		p = tmp
	}

	last.Next = post
	return dummy.Next
}
