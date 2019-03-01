class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0
        while n > 0:
            tmp = n % 2
            if tmp:
                ans += 1
            n /= 2
        return ans
