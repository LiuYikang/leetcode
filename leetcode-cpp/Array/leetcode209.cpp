class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if(nums.size() <= 0)
        {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        sum += nums[0];
        int tmpLen = 0;
        int minLen = sum >= s ? 1 : INT_MAX;
        while (end < nums.size())
        {
            while(sum >= s && start <= end)
            {
                sum -= nums[start];
                start++;
                tmpLen = end - start + 1;
                if(sum >= s && tmpLen < minLen)
                {
                    minLen = tmpLen;
                }
            }
            end++;
            sum += nums[end];
            tmpLen = end - start + 1;
            if(sum >= s && tmpLen < minLen)
            {
                minLen = tmpLen;
            }
        }
        return minLen <= nums.size() ? minLen : 0;
    }
};