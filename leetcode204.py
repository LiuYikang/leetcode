class Solution(object):
    #solution 1
    def countPrimes1(self, n):
        """
        :type n: int
        :rtype: int
        """
        mark = [False] * n
        for i in range(2, n):
            if mark[i]:
                continue
            for j in range(i*i, n, i):
                mark[j] = True
        return n - sum(mark)

    #solution 2
    def countPrimes2(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0
        for i in range(2, n):
            if self.isPrime(i):
                ans += 1
        return ans

    def isPrime(self, num):
        if num <= 1:
            return False
        high = math.sqrt(num) + 1
        for i in range(2, high):
            if num % i == 0:
                return False
        return True
