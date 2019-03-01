class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        res = ""
        strlen = len(s)
        first = 0
        inc =  max(2 * numRows - 2, 1)
        while first < strlen:
            res += s[first]
            first += inc
        for i in range(1, numRows - 1):
            first, second = i, inc - i
            while first < strlen and second < strlen:
                res += s[first]
                res += s[second]
                first += inc
                second += inc
            if first < strlen:
                res += s[first]
        first = numRows - 1 if numRows > 1 else strlen
        while first < strlen:
            res += s[first]
            first += inc
        return res
