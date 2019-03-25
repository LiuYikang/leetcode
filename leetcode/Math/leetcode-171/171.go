package math

func titleToNumber(s string) int {
	if len(s) == 0 {
		return 0
	}

	res := 0
	mul := 1

	for i := len(s) - 1; i >= 0; i-- {
		res += mul * (int)(s[i]-'A'+1)
		mul *= 26
	}
	return res
}
