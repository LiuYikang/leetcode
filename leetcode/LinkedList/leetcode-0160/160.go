package linkedlist

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headA == nil || headB == nil {
		return nil
	}

	l1, l2 := 0, 0
	tmp := headA
	for tmp != nil {
		tmp = tmp.Next
		l1++
	}
	tmp = headB
	for tmp != nil {
		tmp = tmp.Next
		l2++
	}

	for l1 < l2 {
		l2--
		headB = headB.Next
	}
	for l1 > l2 {
		l1--
		headA = headA.Next
	}

	for headA != headB {
		headA = headA.Next
		headB = headB.Next
	}
	return headA
}
