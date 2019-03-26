package string

func reverseWords(s string) string {
	if len(s) == 0 {
		return ""
	}

	strs := []string{}

	i := 0
	for i < len(s) {
		if s[i] == ' ' {
			i++
			continue
		} else {
			start := i
			for i < len(s) && s[i] != ' ' {
				i++
			}
			str := s[start:i]
			strs = append(strs, str)
		}
	}

	res := ""
	for i = len(strs) - 1; i >= 0; i-- {
		res += strs[i]
		if i > 0 {
			res += " "
		}
	}
	return res
}
