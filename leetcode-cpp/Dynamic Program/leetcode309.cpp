class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        
        vector<int> buys(n, 0);
        vector<int> sells(n, 0);
        
        buys[0] = -prices[0];
        
        int profit = sells[0];
        
        for(int i = 1; i < n; i++)
        {
            int diff = prices[i] - prices[i-1];
            sells[i] = max(buys[i-1] + prices[i], sells[i-1] + diff);
            if(i < 2)
            {
                buys[i] = buys[i-1] - diff;
            }
            else
            {
                buys[i] = max(buys[i-1]-diff, sells[i-2] - prices[i]);
            }
            profit = max(profit, sells[i]);
        }
        return profit;
    }
};