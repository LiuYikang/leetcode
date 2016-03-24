class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        minPrice, profit = prices[0], 0
        for i in range(1, len(prices)):
            tmpProfit = prices[i] - minPrice
            if tmpProfit > profit:
                profit = tmpProfit
            if prices[i] <= minPrice:
                minPrice = prices[i]
        return profit
