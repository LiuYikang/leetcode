class Solution {
public:
    int findMin(vector<int>& nums) {
        int minNum = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] > minNum)
            {
                continue;
            }
            else
            {
                minNum = nums[i];
                break;
            }
        }
        return minNum;
    }
};

/**
 * Solution 2
 * Binary search
 */
class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0, end = nums.size() - 1;
        int mid;
        while(start < end)
        {
            if (nums[start] < nums[end])
            {
                return nums[start];
            }
            mid = (start + end) / 2;
            if (nums[start] <= nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return nums[start];
    }
};