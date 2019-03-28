package backtracking

func wordBreak(s string, wordDict []string) []string {
	m := make(map[string][]string)
	return helper(s, wordDict, m)
}

func helper(s string, wordDict []string, m map[string][]string) []string {
	if _, ok := m[s]; ok {
		return m[s]
	}

	res := []string{}
	if len(s) == 0 {
		res = append(res, "")
		return res
	}

	for _, word := range wordDict {
		if len(word) > len(s) {
			continue
		}

		if s[:len(word)] != word {
			continue
		}

		rem := helper(s[len(word):], wordDict, m)
		for _, str := range rem {
			var tmp string
			if len(str) == 0 {
				tmp = word
			} else {
				tmp = word + " " + str
			}
			res = append(res, tmp)
		}
	}

	m[s] = res
	return res
}
