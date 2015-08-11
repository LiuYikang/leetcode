class Solution:
    # @param {string} str
    # @return {integer}
    def myAtoi(self, xStr):
        neg = 1 
        imax, imin = (2 ** 31) - 1, -(2 ** 31)
        if xStr == "":
            return 0
        while xStr[0] == ' ':
            xStr = xStr[1:]
        if xStr[0] == '-' or xStr[0] == '+':
            neg = -1 if xStr[0] == '-' else 1
            xStr = xStr[1:]
        res, i = 0, 0
        while i < len(xStr) and xStr[i] >= '0' and xStr[i] <= '9':
            res = res * 10 + int(xStr[i])
            if res * neg < imin:
                return imin
            if res * neg > imax:
                return imax
            i += 1
        return res * neg
