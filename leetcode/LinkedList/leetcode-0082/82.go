package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	dummy := &ListNode{0, head}
	pre := dummy
	p := head
	flag := false

	for p != nil && p.Next != nil {
		if p.Next.Val == p.Val {
			p = p.Next
			flag = true
		} else {
			if flag {
				flag = false
			} else {
				pre.Next = p
				pre = pre.Next
			}
			p = p.Next
		}
	}
	if flag {
		pre.Next = nil
	} else {
		pre.Next = p
		pre.Next.Next = nil
	}
	return dummy.Next
}
