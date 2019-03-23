package stack

func calculate(s string) int {
	sigh, res := 1, 0
	stack := []int{}

	for i := 0; i < len(s); i++ {
		if s[i] >= '0' && s[i] <= '9' {
			num := 0
			for i < len(s) && s[i] >= '0' && s[i] <= '9' {
				num = num*10 + int(s[i]-'0')
				i++
			}
			res += sigh * num
			i--
		} else if s[i] == '+' {
			sigh = 1
		} else if s[i] == '-' {
			sigh = -1
		} else if s[i] == '(' {
			stack = append(stack, res)
			stack = append(stack, sigh)
			res = 0
			sigh = 1
		} else if s[i] == ')' {
			tmp_sigh := stack[len(stack)-1]
			tmp_res := stack[len(stack)-2]
			stack = stack[:len(stack)-2]
			res = res*tmp_sigh + tmp_res
		} else {
			continue
		}
	}
	return res
}
