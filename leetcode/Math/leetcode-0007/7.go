package math

func reverse(x int) int {
	var MIN = 0x80000000
	var MAX = 0x7FFFFFFF
	var res int
	flag := 1
	if x < 0 {
		flag = -1
		x *= -1
	}
	for x != 0 {
		res = res*10 + x%10
		x /= 10
	}
	res *= flag

	if res < -MIN || res > MAX {
		return 0
	}
	return res
}
