class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0
        for i in range(5, n+1):
            while i >= 5:
                if i % 5 == 0:
                    ans += 1
                    i /= 5
                else:
                    break
        return ans
