class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> ret;
        string tmp;
        vector<string> ip;
        int start = 0;
        DFS(ret, tmp, ip, s, start);
        return ret;
    }
    
    bool isValid(string s)
    {
        if(s[0] == '0')
        {
            return s == "0";
        }
        return true;
    }
    
    void DFS(vector<string>& ret, string tmp, vector<string>& ip, string s, int start)
    {
    	if (ip.size() > 4)return;
    	if (ip.size() == 4 && start == s.length())
    	{
    		string str = ip[0];
    		for (int i = 1; i < 4; i++)
    		{
    			str = str + '.' + ip[i];
    		}
    		ret.push_back(str);
    		return;
    	}
    	int i = tmp.length();
    	while(i < 3 && start < s.length())
    	{
    	    tmp += s[start];
    	    if (!tmp.empty() && (tmp.length() < 3 || tmp <= "255") && isValid(tmp))
    		{
    			ip.push_back(tmp);
    			DFS(ret, "", ip, s, start+1);
    			ip.pop_back();
    		}
    		i++;
    		start++;
    	}
    }
};