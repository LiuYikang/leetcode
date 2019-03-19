/**
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
**/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
	if head == nil {
		return true
	}

	p := head
	len := 0
	for p != nil {
		len++
		p = p.Next
	}

	half := len / 2
	odd := true
	if len%2 == 0 {
		odd = false
	}

	var preHead *ListNode = &ListNode{Val: 0, Next: nil}
	var tmp *ListNode
	p = head
	for ; half > 0; half-- {
		tmp = p.Next
		p.Next = preHead.Next
		preHead.next = p
		p = tmp
	}

	if odd {
		p = p.Next
	}

	return compareList(p, preHead.Next)
}

func compareList(p, q *ListNode) bool {
	for p != nil && q != nil {
		if p.Val != q.Val {
			return false
		}
		p = p.Next
		q = q.Next
	}

	if p != nil || q != nil {
		return false
	}
	return true
}