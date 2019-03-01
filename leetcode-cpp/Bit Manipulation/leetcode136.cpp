class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return NULL;
        
        int ret = nums[0];
        for(int i = 1; i < n; i++)
        {
            ret ^= nums[i];
        }
        return ret;
    }
};