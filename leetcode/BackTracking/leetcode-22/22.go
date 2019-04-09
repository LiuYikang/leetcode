package backtracking

func generateParenthesis(n int) []string {
	res := []string{}

	if n == 0 {
		return res
	}

	helper(&res, "", n, n)
	return res
}

func helper(res *[]string, s string, left, right int) {
	if left > right {
		return
	}

	if left == 0 && right == 0 {
		*res = append(*res, s)
		return
	}

	if left > 0 {
		helper(res, s+"(", left-1, right)
	}

	if right > 0 {
		helper(res, s+")", left, right-1)
	}
}
