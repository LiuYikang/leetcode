class Solution {
public:
    int totalNQueens(int n) {
        int ret = 0;
        string str(n, '.');
        vector<string> tmp(n, str);
        DFS(ret, tmp, n, 0);
        return ret;
    }
    
    void DFS(int& ret, vector<string>& tmp, int n, int count)
    {
        if(n == count)
        {
            ret++;
        }
        else
        {
            for(int i = 0; i < n; i++)
            {
                int row = count-1, col1 = i-1, col2 = i+1;
                bool flag = false;
                while(row >= 0)
                {
                    if(tmp[row][i] == 'Q')
                    {
                        flag = true;
                        break;
                    }
                    if(col1 >= 0 && tmp[row][col1] == 'Q')
                    {
                        flag = true;
                        break;
                    }
                    if(col2 < n && tmp[row][col2] == 'Q')
                    {
                        flag = true;
                        break;
                    }
                    row--;
                    col1--;
                    col2++;
                }
                if(flag)continue;
                else
                {
                    tmp[count][i] = 'Q';
                    DFS(ret, tmp, n, count+1);
                    tmp[count][i] = '.';
                }
            }
        }
        return;
    }
};