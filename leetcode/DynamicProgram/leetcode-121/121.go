package dynamicprogram

func maxProfit(prices []int) int {
	if prices == nil || len(prices) < 2 {
		return 0
	}

	buy, profit := prices[0], 0

	for _, price := range prices[1:] {
		if buy > price {
			buy = price
		} else {
			if price-buy > profit {
				profit = price - buy
			}
		}
	}
	return profit
}
