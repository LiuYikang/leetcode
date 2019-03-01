/**
 * Solution
 * Backtracking and dereplication
 */

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> total;
        vector<int> sub;
        int end = nums.size() - 1;
        sort(nums.begin(), nums.end());
        DFS(nums, 0, end, total, sub);
        return total;
    }
    
    void DFS(vector<int>& nums, int start, int end, vector<vector<int>>& total, vector<int>& sub)
    {
        total.push_back(sub);
        for(int i = start; i <= end; i++)
        {
            if(i >= start + 1 && nums[i] == nums[i-1])
            {
                continue;
            }
            sub.push_back(nums[i]);
            DFS(nums, i+1, end, total, sub);
            sub.pop_back();
        }
        return;
    }
};