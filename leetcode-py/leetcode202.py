class Solution(object):
    def isHappy1(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 1:
            return True
        if n == 0:
            return False
        tmp = 0
        while n:
            tmp += (n % 10) ** 2
            n /= 10
        return self.isHappy(tmp)

    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        appeared_nums = set()
        while n > 1 and (n not in appeared_nums):
            appeared_nums.add(n)
            n = sum(map(lambda x: int(x) * int(x), list(str(n))))
        return n == 1
