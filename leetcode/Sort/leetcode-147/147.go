package sort

// ListNode : Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func insertionSortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	ret := &ListNode{0, nil}
	cur := head
	for cur != nil {
		tmp := cur.Next
		insertList(cur, ret)
		cur = tmp
	}
	return ret.Next
}

func insertList(node, pre *ListNode) {
	head := pre.Next
	for head != nil && node.Val > head.Val {
		pre = head
		head = head.Next
	}
	pre.Next = node
	node.Next = head
}
