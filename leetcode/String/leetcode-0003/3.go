package string

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}
	res := 0
	m := make(map[byte]int)
	i, j := 0, 0
	for i < len(s) && j < len(s) {
		for val, ok := m[s[j]]; ok && val >= i; i++ {
			m[s[i]] = -1
		}
		m[s[j]] = j
		j++
		res = max(res, j-i)
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
