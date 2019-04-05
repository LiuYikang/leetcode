package string

func lengthOfLastWord(s string) int {
	if len(s) == 0 {
		return 0
	}

	res := 0
	i := len(s) - 1

	for i >= 0 && s[i] == ' ' {
		i--
	}

	for i >= 0 && s[i] != ' ' {
		i--
		res++
	}
	return res
}
