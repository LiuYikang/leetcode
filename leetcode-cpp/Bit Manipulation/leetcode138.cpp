class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;
        if(n == 0) return ans;
        int x = nums[0];
        for(int i = 1; i < n; i++)x ^= nums[i];
        int lowbit = x & -x;
        
        int a = 0, b = 0;
        for(int i = 0; i < n; i++)
        {
            if (nums[i] & lowbit)
            {
                a ^= nums[i];
            }
            else
            {
                b ^= nums[i];
            }
        }
        
        ans.push_back(a);
        ans.push_back(b);
        return ans;
    }
};