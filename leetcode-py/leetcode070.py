class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        c = [0, 1, 2]
        for i in range(3, n+1):
            c[i] = c[i-1] + c[i-2]
        return c[n]
