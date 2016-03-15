class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        ans = [0] * (n+1)
        ans[1] = 1
        p2, p3, p5 = 1, 1, 1
        for i in range(2, n+1):
            ans[i] = min(ans[p2]*2, ans[p3]*3, ans[p5]*5)
            if ans[i] == ans[p2]*2:
                p2 += 1
            if ans[i] == ans[p3]*3:
                p3 += 1
            if ans[i] == ans[p5]*5:
                p5 += 1
        return ans[n]
