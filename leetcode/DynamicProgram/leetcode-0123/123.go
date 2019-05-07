package dynamicprogram

func maxProfit(prices []int) int {
	if prices == nil || len(prices) == 0 {
		return 0
	}

	global := make([]int, 3)
	local := make([]int, 3)

	for i := 0; i < len(prices)-1; i++ {
		diff := prices[i+1] - prices[i]
		for j := 2; j >= 1; j-- {
			local[j] = max(global[j-1]+max(0, diff), local[j]+diff)
			global[j] = max(global[j], local[j])
		}
	}
	return global[2]
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
