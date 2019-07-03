package linkedlist

import "container/heap"

// ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	if lists == nil || len(lists) == 0 {
		return nil
	}

	return merge(lists, 0, len(lists)-1)
}

func merge(lists []*ListNode, low, high int) *ListNode {
	if low >= high {
		return lists[low]
	}

	mid := (high-low)/2 + low
	p := merge(lists, low, mid)
	q := merge(lists, mid+1, high)
	return mergeList(p, q)
}

func mergeList(head1, head2 *ListNode) *ListNode {
	if head1 == nil && head2 == nil {
		return nil
	}

	dummy := &ListNode{}
	pre := dummy

	for head1 != nil && head2 != nil {
		if head1.Val < head2.Val {
			pre.Next = head1
			head1 = head1.Next
		} else {
			pre.Next = head2
			head2 = head2.Next
		}
		pre = pre.Next
	}

	if head1 != nil {
		pre.Next = head1
	}

	if head2 != nil {
		pre.Next = head2
	}

	return dummy.Next
}

// solution 2
func mergeKLists2(lists []*ListNode) *ListNode {
	if lists == nil || len(lists) == 0 {
		return nil
	}

	hp := ListNodeHeap{}
	for i := 0; i < len(lists); i++ {
		if lists[i] == nil {
			continue
		}
		hp = append(hp, lists[i])
	}

	dummy := &ListNode{0, nil}
	p := dummy
	heap.Init(&hp)
	for len(hp) != 0 {
		tmp := heap.Pop(&hp).(*ListNode)
		p.Next = tmp
		p = p.Next
		if tmp.Next != nil {
			heap.Push(&hp, tmp.Next)
		}
	}
	return dummy.Next
}

type ListNodeHeap []*ListNode

func (p ListNodeHeap) Len() int {
	return len(p)
}

func (p ListNodeHeap) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func (p ListNodeHeap) Less(i, j int) bool {
	return p[i].Val < p[j].Val
}

func (p *ListNodeHeap) Push(h interface{}) {
	*p = append(*p, h.(*ListNode))
}

func (p *ListNodeHeap) Pop() (x interface{}) {
	n := len(*p)
	x = (*p)[n-1]
	*p = (*p)[:n-1]
	return x
}
