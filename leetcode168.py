class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        chr(ord('A') + 1)
        ans = ''
        while n:
            n -= 1
            ans = chr(ord('A') + (n % 26)) + ans
            n /= 26
        return ans
