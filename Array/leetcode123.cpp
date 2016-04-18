class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n == 0 || n == 1)
        {
            return 0;
        }
        vector<int> profit(n, 0);
        int preMax = 0;
        int minPrice = prices[0];
        
        for(int i = 1; i < n; i++)
        {
            minPrice = min(prices[i], minPrice);
            preMax = max(preMax, prices[i] - minPrice);
            profit[i] = preMax;
        }
        
        int postMax = 0;
        int maxPrice = prices[n-1];
        int maxProfit = 0;
        for(int i = n - 2; i >= 0; i--)
        {
            maxPrice = max(prices[i], maxPrice);
            postMax = max(postMax, maxPrice - prices[i]);
            profit[i] += postMax;
            maxProfit = max(maxProfit, profit[i]);
        }
        return maxProfit;
    }
};