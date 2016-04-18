class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans;
        ans.push_back(0);
        int len = 1;
        
        for(int i = 1; i <= num; i++)
        {
            for(int j = 1; j <= len && i <= num; j++, i++)
            {
                int tmp = len / 2;
                if(j <= tmp)
                {
                    ans.push_back(ans[tmp+j-1]);
                }
                else
                {
                    ans.push_back(ans[tmp+j-1]+1);
                }
            }
            i--;
            len *= 2;
        }
        return ans;
    }
};