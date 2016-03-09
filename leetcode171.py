class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = 0
        l = len(s)
        for i in range(l):
            ans += ord(s[i]) * (26 ** (l-i-1))
        return ans
