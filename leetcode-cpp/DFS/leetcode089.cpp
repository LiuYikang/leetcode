class Solution {
public:
    vector<int> grayCode(int n) {
        int add = 1;
        vector<int> ret;
        ret.push_back(0);
        for(int i = 1; i <= n; i++)
        {
            int len = ret.size();
            int tmp = add << i - 1;
            for(int j = len - 1; j >= 0; j--)
            {
                ret.push_back(ret[j] + tmp);
            }
        }
        return ret;
    }
};