package math

func isPalindrome(x int) bool {
	if x < 0 || x%10 == 0 {
		return false
	}
	p := 0
	tmp := x
	for tmp != 0 {
		p = p*10 + tmp%10
		tmp /= 10
	}
	return p == x
}
