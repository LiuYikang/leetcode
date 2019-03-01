class Solution {
public:
    string reverseString(string s) {
        int low = 0, high = s.size() - 1;
        while(low < high)
        {
            char c = s[low];
            s[low] = s[high];
            s[high] = c;
            low++;
            high--;
        }
        return s;
    }
};