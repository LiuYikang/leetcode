package stack

import "container/list"

func longestValidParentheses(s string) int {
	if len(s) < 2 {
		return 0
	}

	start, res := 0, 0
	stack := list.New()

	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			stack.PushBack(i)
		} else {
			if stack.Len() == 0 {
				start = i + 1
			} else {
				stack.Remove(stack.Back())
				if stack.Len() == 0 {
					res = max(res, i-start+1)
				} else {
					res = max(res, i-stack.Back().Value.(int))
				}
			}
		}
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
