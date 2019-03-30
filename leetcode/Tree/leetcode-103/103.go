package tree

import "container/list"

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}
	orderQ := list.New()
	reverseQ := list.New()

	orderQ.PushBack(root)

	for orderQ.Len() > 0 || reverseQ.Len() > 0 {
		tmp1 := []int{}
		for orderQ.Len() > 0 {
			node := orderQ.Front().Value.(*TreeNode)
			orderQ.Remove(orderQ.Front())
			tmp1 = append(tmp1, node.Val)
			if node.Left != nil {
				reverseQ.PushBack(node.Left)
			}
			if node.Right != nil {
				reverseQ.PushBack(node.Right)
			}
		}
		if len(tmp1) > 0 {
			res = append(res, tmp1)
		}

		tmp2 := []int{}
		for reverseQ.Len() > 0 {
			node := reverseQ.Back().Value.(*TreeNode)
			reverseQ.Remove(reverseQ.Back())
			tmp2 = append(tmp2, node.Val)
			if node.Right != nil {
				orderQ.PushFront(node.Right)
			}
			if node.Left != nil {
				orderQ.PushFront(node.Left)
			}
		}
		if len(tmp2) > 0 {
			res = append(res, tmp2)
		}
	}
	return res
}
