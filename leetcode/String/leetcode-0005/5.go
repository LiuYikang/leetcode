package string

func longestPalindrome(s string) string {
	if len(s) == 0 {
		return s
	}
	max := 0
	res := ""
	for i := 0; i < len(s); i++ {
		helper(s, i, i, &max, &res)
		helper(s, i, i+1, &max, &res)
	}
	return res
}

func helper(s string, left, right int, max *int, res *string) {
	for left >= 0 && right < len(s) && s[left] == s[right] {
		left--
		right++
	}
	if *max < right-left+1 {
		*max = right - left + 1
		*res = s[left+1 : right]
	}
}
