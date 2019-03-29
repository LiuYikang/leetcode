package tree

import "container/list"

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	stack := list.New()
	node, pre := root, &TreeNode{0, nil, nil}
	for node != nil {
		stack.PushBack(node)
		pre.Left = node
		pre = pre.Left
		node = node.Left
	}

	for stack.Len() != 0 {
		node = stack.Back().Value.(*TreeNode)
		stack.Remove(stack.Back())
		if node.Right != nil {
			tmp := node.Right
			node.Right = nil
			node = tmp
			for node != nil {
				stack.PushBack(node)
				pre.Left = node
				pre = pre.Left
				node = node.Left
			}
		}
	}

	node = root
	for node != nil {
		node.Right = node.Left
		node.Left = nil
		node = node.Right
	}
}
