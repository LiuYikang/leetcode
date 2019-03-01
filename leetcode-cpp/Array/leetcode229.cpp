/**
 * Solution
 * Boyer-Moore Majority Vote algorithm
 * With two candidate and vote
 */

class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int candidate1, candidate2, count1 = 0, count2 = 0;
        int numsLen = nums.size();
        for (int i = 0; i < numsLen; i++)
        {
            if(nums[i] == candidate1)
            {
                count1++;
            }
            else if(nums[i] == candidate2)
            {
                count2++;
            }
            else if(count1 == 0)
            {
                count1++;
                candidate1 = nums[i];
            }
            else if(count2 == 0)
            {
                count2++;
                candidate2 = nums[i];
            }
            else
            {
                count1--;
                count2--;
            }
        }
        vector<int> ans;
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < numsLen; i++)
        {
            if(nums[i] == candidate1)count1++;
            if(nums[i] == candidate2)count2++;
        }
        if(count1 > numsLen / 3)ans.push_back(candidate1);
        if(count2 > numsLen / 3)ans.push_back(candidate2);
        return ans;
    }
};