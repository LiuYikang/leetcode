package dynamicprogram

func maxProfit(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}

	buy, profit := prices[0], 0
	for i := 1; i < len(prices); i++ {
		if prices[i] < prices[i-1] {
			profit += prices[i-1] - buy
			buy = prices[i]
		}
	}
	profit += prices[len(prices)-1] - buy
	return profit
}
