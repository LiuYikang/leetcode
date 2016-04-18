class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        return peak(nums, 0, nums.size()-1);
    }
    int peak(vector<int>& nums, int start, int end)
    {
        if(start == end)
        {
            return start;
        }
        int mid = (start + end) / 2;
        int tmp = mid+1;
        if(nums[mid] > nums[tmp])
        {
            return peak(nums, start, mid);
        }
        else
        {
            return peak(nums, tmp, end);
        }
    }
};