class Solution:
    # @param {integer} dividend
    # @param {integer} divisor
    # @return {integer}
    def divide(self, dividend, divisor):
        flag, ans = 0, 0
        if dividend < 0:
            dividend = -dividend
            flag = flag ^ 1
        if divisor < 0:
            divisor = -divisor
            flag = flag ^ 1
        while dividend >= divisor:
            count, newDivisor = 1, divisor
            while newDivisor + newDivisor <= dividend:
                newDivisor = newDivisor + newDivisor
                count = count + count
            dividend -= newDivisor
            ans += count
        if flag:
            return max(-ans, -2147483648)
        else:
            return min(ans, 2147483647)
