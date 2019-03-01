class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if(n < 2)return 0;
        if (k >= n) return maxProfit2(prices);
        
        vector<int>local(k+1, 0);
        vector<int>global(k+1, 0);
        
        for(int i = 0; i < n-1; i++)
        {
            int diff = prices[i+1] - prices[i];
            
            for(int j = k; j >= 1; j--)
            {
                local[j] = max(local[j] + diff, global[j-1] + max(0, diff));
                global[j] = max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    int maxProfit2(vector<int>& prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
};