package stack

import "container/list"

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}

	stack := list.New()

	for i := 0; i < len(s); i++ {
		if s[i] == '(' || s[i] == '[' || s[i] == '{' {
			stack.PushBack(s[i])
		} else if stack.Len() == 0 {
			return false
		} else if s[i] == ')' {
			if stack.Back().Value.(byte) != '(' {
				return false
			}
			stack.Remove(stack.Back())
		} else if s[i] == ']' {
			if stack.Back().Value.(byte) != '[' {
				return false
			}
			stack.Remove(stack.Back())
		} else {
			if stack.Back().Value.(byte) != '{' {
				return false
			}
			stack.Remove(stack.Back())
		}
	}

	if stack.Len() > 0 {
		return false
	}
	return true
}
