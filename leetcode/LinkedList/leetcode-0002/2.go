package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := new(ListNode)
	pre := dummy
	sum, tmp := 0, 0

	for l1 != nil && l2 != nil {
		sum = l1.Val + l2.Val + tmp
		tmp = sum / 10
		sum %= 10
		node := &ListNode{sum, nil}
		pre.Next = node
		pre = pre.Next
		l1 = l1.Next
		l2 = l2.Next
	}

	for l1 != nil {
		sum = l1.Val + tmp
		tmp = sum / 10
		sum %= 10
		node := &ListNode{sum, nil}
		pre.Next = node
		pre = pre.Next
		l1 = l1.Next
	}

	for l2 != nil {
		sum = l2.Val + tmp
		tmp = sum / 10
		sum %= 10
		node := &ListNode{sum, nil}
		pre.Next = node
		pre = pre.Next
		l2 = l2.Next
	}

	if tmp != 0 {
		node := &ListNode{tmp, nil}
		pre.Next = node
	}
	return dummy.Next
}
