package tree

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	_, res := helper(root)
	return res
}

func helper(root *TreeNode) (int, bool) {
	if root == nil {
		return 0, true
	}

	left, lb := helper(root.Left)
	right, rb := helper(root.Right)
	balance := lb && rb
	if left-right > 1 || right-left > 1 {
		balance = false
	}

	return 1 + max(left, right), balance
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
