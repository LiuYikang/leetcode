class Solution:
    # @param {integer} x
    # @return {integer}
    def reverse(self, x):
        neg = 1
        if x < 0:
            neg = -1
            xStr = str(x)[1:]
        else:
            xStr = str(x)
        x = int(xStr[:: -1])
        return 0 if x > 2 ** 31 else x * neg
