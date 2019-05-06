package tree

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	if preorder == nil || len(preorder) == 0 {
		return nil
	}
	root := &TreeNode{preorder[0], nil, nil}
	left := 0
	for i := 0; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
		left++
	}
	root.Left = buildTree(preorder[1:left+1], inorder[:left])
	root.Right = buildTree(preorder[left+1:], inorder[left+1:])
	return root
}
