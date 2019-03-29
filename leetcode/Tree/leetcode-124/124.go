package tree

import "math"

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	maxSum := math.MinInt32
	maxLocalNode(root, &maxSum)
	return maxSum
}

func maxLocalNode(root *TreeNode, maxSum *int) int {
	if root == nil {
		return 0
	}

	left := maxLocalNode(root.Left, maxSum)
	right := maxLocalNode(root.Right, maxSum)

	res := max(root.Val, root.Val+max(left, right))
	localMax := max(res, root.Val+right+left)
	*maxSum = max(localMax, *maxSum)
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
