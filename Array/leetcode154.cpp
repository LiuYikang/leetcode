/**
 * Solution one
 * recursion and binary search
 */

class Solution {
public:
    int findMin(vector<int>& nums) {
        return minNum(nums, 0, nums.size() - 1);
    }
    
    int minNum(vector<int>& nums, int start, int end)
    {
        if(start == end)
        {
            return nums[start];
        }
        int mid;
        if (nums[start] < nums[end])
        {
            return nums[start];
        }
        mid = (start + end) / 2;
        int tmp1 = minNum(nums, start, mid);
        int tmp2 = minNum(nums, mid + 1, end);
        return tmp1 < tmp2 ? tmp1 : tmp2;
    }
};


/**
 * Solution two
 * Just binary search
 */
class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;
        int mid = 0;

        while(start < end) 
        {
            mid = (start + end) / 2;

            if (nums[mid] > nums[end]) 
            {
                start = mid + 1;
            }
            else if (nums[mid] < nums[end]) 
            {
                end = mid;
            }
            else
            {
                end--;
            }
        }
        return nums[start];
    }
};