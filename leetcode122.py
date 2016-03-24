class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        minPrice, profit, tmpProfit = prices[0], 0, 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                tmpProfit = prices[i] - minPrice
            if prices[i] <= prices[i-1]:
                profit += tmpProfit
                tmpProfit = 0
                minPrice = prices[i]
        return profit if tmpProfit == 0 else profit + tmpProfit
