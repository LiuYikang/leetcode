class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ret;
        vector<string> ans;
        int start = 0;
        string tmp;
        DFS(ret, ans, tmp, s, start);
        return ret;
    }
    
    void DFS(vector<vector<string>>& ret, vector<string>& ans, string tmp, string s, int start)
    {
        if(start == s.size())
        {
            ret.push_back(ans);
            return;
        }
        for(int i = start; i < s.size(); i++)
        {
            tmp += s[i];
            if(isPalidrome(tmp))
            {
                ans.push_back(tmp);
                DFS(ret, ans, "", s, i+1);
                ans.pop_back();
            }
        }
        return;
    }
    
    bool isPalidrome(string s)
    {
        int low = 0;
        int high = s.size() - 1;
        while(low < high)
        {
            if(s[low] != s[high])
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
};