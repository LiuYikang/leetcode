package dynamicprogram

func climbStairs(n int) int {
	if n < 2 {
		return n
	}
	p, q := 1, 1
	for i := 2; i <= n; i++ {
		p, q = q, p+q
	}
	return q
}
