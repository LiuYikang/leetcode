/**
 * Solution
 * Dynamic Programming
 */

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        int i = 1;
        vector<vector<int>> minLen;
        minLen.push_back(triangle[0]);
        while(i < n)
        {
            minLen.push_back(vector<int>(i+1, 0));
            for (int j = 0; j <= i; j++)
            {
                if(j == 0)
                {
                    minLen[i][j] = minLen[i-1][j] + triangle[i][j];
                }
                else if(j == i)
                {
                    minLen[i][j] = minLen[i-1][j-1] + triangle[i][j];
                }
                else
                {
                    minLen[i][j] = min(minLen[i-1][j-1], minLen[i-1][j]) + triangle[i][j];
                }
            }
            i++;
        }
        int ret = minLen[n-1][0];
        for(int j = 1; j < n; j++)
        {
            if(ret > minLen[n-1][j])
            {
                ret = minLen[n-1][j];
            }
        }
        return ret;
    }
};