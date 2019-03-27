package hashtable

func isHappy(n int) bool {
	m := make(map[int]bool)

	m[n] = true

	for n != 1 {
		n = help(n)
		if m[n] {
			return false
		} else {
			m[n] = true
		}
	}
	return true
}

func help(n int) int {
	res := 0
	for n > 0 {
		digit := n % 10
		n /= 10
		res += digit * digit
	}
	return res
}
