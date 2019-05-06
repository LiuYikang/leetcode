package tree

// TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	if inorder == nil || len(inorder) == 0 {
		return nil
	}
	root := &TreeNode{postorder[len(postorder)-1], nil, nil}
	left := 0
	for i := 0; i < len(inorder); i++ {
		if inorder[i] == postorder[len(postorder)-1] {
			break
		}
		left++
	}
	root.Left = buildTree(inorder[:left], postorder[:left])
	root.Right = buildTree(inorder[left+1:], postorder[left:len(postorder)-1])
	return root
}
