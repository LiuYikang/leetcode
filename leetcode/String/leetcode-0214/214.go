package string

func shortestPalindrome(s string) string {
	r := reverse(s)
	t := s + "#" + r

	next := make([]int, len(t))

	for i := 1; i < len(t); i++ {
		j := next[i-1]
		for j > 0 && t[i] != t[j] {
			j = next[j-1]
		}
		if t[i] == t[j] {
			j += 1
		}
		next[i] = j
	}
	return r[0:len(s)-next[len(t)-1]] + s
}

func reverse(s string) string {
	runes := []rune(s)

	for from, to := 0, len(runes)-1; from < to; from, to = from+1, to-1 {
		runes[from], runes[to] = runes[to], runes[from]
	}

	return string(runes)
}
