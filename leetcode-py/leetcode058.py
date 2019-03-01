class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans, flag = 0, 1
        for item in s:
            if item == ' ':
                flag = 1
            else:
                if flag:
                    flag, ans = 0, 0
                ans += 1
        return ans
