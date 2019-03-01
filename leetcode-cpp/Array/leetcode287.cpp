/**
 * Solution one
 */
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        /*like a cycle linklist, find the start point of the cycle*/
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
};


/**
 * Solution two
 */
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        /*find the right of each num*/
        int n = nums.size();
        for (int i = 0; i < n;)
        {
            if(nums[nums[i]-1] != nums[i])
            {
                swap(nums[i], nums[nums[i]-1]);
            }
            else
            {
                if(nums[i] - 1 == i)
                {
                    i++;
                }
                else
                {
                    return nums[i];
                }
            }
        }
    }
};