package backtracking

func letterCombinations(digits string) []string {
	res := []string{}

	if len(digits) == 0 {
		return res
	}

	letters := []string{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
	helper(&res, letters, "", digits, 0)
	return res
}

func helper(res *[]string, letters []string, str, digits string, i int) {
	if i == len(digits) {
		*res = append(*res, str)
		return
	}

	letter := letters[digits[i]-'0']
	for j := 0; j < len(letter); j++ {
		helper(res, letters, str+string(letter[j]), digits, i+1)
	}
}
