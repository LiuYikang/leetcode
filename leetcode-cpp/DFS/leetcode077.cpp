class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ret;
        vector<int> tmp;
        DFS(ret, tmp, n, k, 1);
        return ret;
    }
    
    void DFS(vector<vector<int>>& ret, vector<int>& tmp, int n, int k, int start)
    {
        if(tmp.size() == k)
        {
            ret.push_back(tmp);
        }
        else
        {
            for(int i = start; i <= n; i++)
            {
                tmp.push_back(i);
                DFS(ret, tmp, n, k, i+1);
                tmp.pop_back();
            }
        }
    }
};