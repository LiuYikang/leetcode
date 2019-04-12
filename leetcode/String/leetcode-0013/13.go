package string

func romanToInt(s string) int {
	m := map[byte]int{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

	res := 0
	pre := 0

	for i := 0; i < len(s); i++ {
		tmp := m[s[i]]
		if tmp > pre {
			res -= pre * 2
		}
		res += tmp
		pre = tmp
	}
	return res
}
