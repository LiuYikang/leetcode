class Solution {
public:
    int singleNumber(vector<int>& nums) {
        vector<int> bit(32, 0);
        for(int i = 0; i < nums.size(); i++)
        {
            for(int j = 0; j < 32; j++)
            {
                int bitnum = nums[i] >> j;
                if(bitnum == 0) break;
                bit[j] += bitnum&1;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < 32; i++)
        {
            ans += (bit[i] % 3) << i;
        }
        return ans;
    }
};