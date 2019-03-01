class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1.0
        i, ans = 1, x
        k = abs(n)
        while i < k/2:
            ans *= ans
            i += i
        return ans * self.myPow(x, k-i) if n > 0 else 1/(ans*self.myPow(x, k-i))
