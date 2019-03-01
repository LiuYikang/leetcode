/**
 * Solution
 * DFS solution, Backtracking
 */
class Solution {
public:
    void DFS(int k, int start, int n, vector<vector<int>>& total, vector<int>& ans)
    {
        if(k == 0 && n == 0)
        {
            total.push_back(ans);
            return;
        }
        for(;start <= 9; start++)
        {
            if(start <= n)
            {
                ans.push_back(start);
                DFS(k-1, start+1, n-start, total, ans);
                ans.pop_back();
            }
        }
        return;
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ret;
        vector<int> tmp;
        DFS(k, 1, n, ret, tmp);
        return ret;
    }
};