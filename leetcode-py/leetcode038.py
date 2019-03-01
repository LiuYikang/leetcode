class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = str(1)
        if n == 1:
            return '1'
        for i in range(1, n):
            ret = ""
            num = 0
            j = 0
            length = len(s)
            while j < length:
                count = 0
                num = s[j]
                while j < length and s[j] == num:
                    count += 1
                    j += 1
                ret += str(count) + str(num)
            s = ret
            print s
        return s
