/**
309. Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
**/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - prices[i - 1];
            buy[i] = Math.max(cooldown[i - 1], buy[i - 1]);
            sell[i] = Math.max(sell[i - 1] + profit, buy[i - 1] + profit);
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
        }
        return Math.max(buy[n - 1], Math.max(sell[n - 1], cooldown[n - 1]));
    }
}
