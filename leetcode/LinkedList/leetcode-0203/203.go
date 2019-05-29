package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}

	dummy := &ListNode{0, head}
	pre, loc := dummy, head

	for loc != nil {
		if loc.Val == val {
			pre.Next = loc.Next
			loc = loc.Next
		} else {
			pre = pre.Next
			loc = loc.Next
		}
	}
	return dummy.Next
}
