package string

func intToRoman(num int) string {
	roman := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
	n := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}

	res := ""

	for i, v := range roman {
		for num >= n[i] {
			num -= n[i]
			res += v
		}
	}
	return res
}
