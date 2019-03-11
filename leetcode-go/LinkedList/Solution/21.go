/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    if l1 == nil && l2 == nil {
        return nil
    }

    head := &ListNode{Val: 0, Next: nil}
    l := head

    for l1 != nil && l2 != nil {
        if l1.Val < l2.Val {
            l.Next = l1
            l1 = l1.Next
        } else {
            l.Next = l2
            l2 = l2.Next
        }
        l = l.Next
    }

    if l1 != nil {
        l.Next = l1
    }

    if l2 != nil {
        l.Next = l2
    }

    return head.Next
}
