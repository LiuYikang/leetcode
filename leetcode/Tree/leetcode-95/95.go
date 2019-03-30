package tree

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func generateTrees(n int) []*TreeNode {
	res := []*TreeNode{}
	if n < 1 {
		return res
	}
	return helper(1, n)
}

func helper(start, end int) []*TreeNode {
	res := []*TreeNode{}

	if start > end {
		res = append(res, nil)
		return res
	}

	for i := start; i <= end; i++ {
		left := helper(start, i-1)
		right := helper(i+1, end)

		for _, l := range left {
			for _, r := range right {
				node := &TreeNode{i, nil, nil}
				node.Left = l
				node.Right = r
				res = append(res, node)
			}
		}
	}
	return res
}
